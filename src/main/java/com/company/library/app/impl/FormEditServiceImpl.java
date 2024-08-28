package com.company.library.app.impl;

import com.company.library.app.api.FormEditService;
import com.company.library.entity.*;
import com.company.library.exceptions.AlreadyTakeBookException;
import com.company.library.exceptions.HasSameBookException;
import com.company.library.exceptions.IncorrectDatesException;
import com.company.library.exceptions.NullAmountException;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class FormEditServiceImpl implements FormEditService {
    @Autowired
    private DataManager dataManager;


    @Override
    public void validateForm(Form form) throws IncorrectDatesException, HasSameBookException, AlreadyTakeBookException, NullAmountException {
        if(alreadyTakeBook(form.getReader(), form.getBook(), form.getBook().getLibrary(), form.getIssuanceDate(), form.getReturnDate()))
            throw new AlreadyTakeBookException("book is already taken");

        if(hasTheSameBook(form.getReader(), form.getBook(),  form.getIssuanceDate(), form.getReturnDate()))
            throw new HasSameBookException("reader have the same book");

        if(incorrectDates(form.getIssuanceDate(), form.getReturnDate()))
            throw new IncorrectDatesException("dates are incorrect");

        if(nullAmount(form.getBook(),form.getIssuanceDate(),form.getReturnDate()))
            throw new NullAmountException("all books has been taken");

    }


    //возвращает случайного сотрудника библиотеки
    @Override
    public Worker findWorkerFromLibrary(Library library) {
        List<Worker> workerList = library.getWorkers();
        Random rand = new Random();
        return workerList.get(rand.nextInt(workerList.size()));
    }


    //проверка на период дат
    private boolean incorrectDates(LocalDate startDate, LocalDate endDate) {
        return endDate.isBefore(startDate);
    }

    //пересечение дат
    private boolean dateIntersection(LocalDate date1, LocalDate date2, LocalDate date3, LocalDate date4){
        return ((date1.isAfter(date3) && date2.isBefore(date4)) ||
                (date1.isAfter(date3) && date1.isBefore(date4)) ||
                (date2.isAfter(date3) && date2.isBefore(date4)) ||
                (date1.isBefore(date3) && date2.isAfter(date4))) ||
                (date1.equals(date3) || (date2.equals(date4)));
    }

    //проверка на взятие книг в этом периоде дат из библиотеки
    private boolean alreadyTakeBook(Reader reader, Book book, Library library, LocalDate issuanceDate, LocalDate returnDate) {
        List<Form> formsList = reader.getForms();
        for (Form f : formsList) {
            if (library.equals(f.getBook().getLibrary())) {
                return dateIntersection(issuanceDate,returnDate,f.getIssuanceDate(),f.getReturnDate());
            }
        }
        return false;
    }

    //проверка на взятие такой же книги
    private boolean hasTheSameBook(Reader reader, Book book, LocalDate issuanceDate, LocalDate returnDate) {
        List<Form> formsList = reader.getForms();
        for (Form f : formsList) {
            if (book.getAuthor().equals(f.getBook().getAuthor()) && book.getTitle().equals(f.getBook().getTitle())) {
                return  dateIntersection(issuanceDate,returnDate,f.getIssuanceDate(),f.getReturnDate());}
        }
        return false;
    }

    //проверка на количество книг в библиотеке
    private boolean nullAmount(Book book, LocalDate issuanceDate, LocalDate returnDate){
        BigDecimal amount = BigDecimal.ZERO;
        List<Form> formsList = dataManager.load(Form.class)
                .all().list();
        for (Form f : formsList) {
            if (book.equals(f.getBook())){
                if (dateIntersection(issuanceDate,returnDate,f.getIssuanceDate(),f.getReturnDate())){
                    amount = amount.add(BigDecimal.ONE);
                }
            }
        }
        return (amount.equals(book.getAmount()));
    }
}
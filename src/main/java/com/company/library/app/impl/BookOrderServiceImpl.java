package com.company.library.app.impl;

import com.company.library.app.api.BookOrderService;
import com.company.library.app.api.FormEditService;
import com.company.library.entity.BookOrder;
import com.company.library.entity.Form;
import com.company.library.entity.Worker;
import com.company.library.exceptions.AlreadyTakeBookException;
import com.company.library.exceptions.HasSameBookException;
import com.company.library.exceptions.IncorrectDatesException;
import com.company.library.exceptions.NullAmountException;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookOrderServiceImpl implements BookOrderService {

    @Autowired
    private DataManager dataManager;

    @Autowired
    private FormEditService formEditService;

    @Override
    public void saveOrderToForms(BookOrder bookOrder) throws AlreadyTakeBookException, IncorrectDatesException, HasSameBookException, NullAmountException {
        Worker randomWorker = formEditService.findWorkerFromLibrary(bookOrder.getLibrary());

        List<Form> forms = bookOrder.getBooks()
                .stream()
                .map((book -> {
                    Form form = dataManager.create(Form.class);
                    form.setReader(bookOrder.getReader());
                    form.setWorker(randomWorker);
                    form.setBook(book);
                    form.setIssuanceDate(bookOrder.getIssuanceDate());
                    form.setReturnDate(bookOrder.getReturnDate());
                    return form;
                }))
                .collect(Collectors.toList());

        for (Form f : forms) {
            formEditService.validateForm(f);
            dataManager.save(f);
        }
    }
}

package com.company.library.app.api;

import com.company.library.entity.Form;
import com.company.library.entity.Library;
import com.company.library.entity.Worker;
import com.company.library.exceptions.AlreadyTakeBookException;
import com.company.library.exceptions.HasSameBookException;
import com.company.library.exceptions.IncorrectDatesException;
import com.company.library.exceptions.NullAmountException;

public interface FormEditService {

    void validateForm(Form form) throws AlreadyTakeBookException, IncorrectDatesException, HasSameBookException, NullAmountException;

    //возвращает случайного сотрудника библиотеки
    Worker findWorkerFromLibrary(Library library);
}

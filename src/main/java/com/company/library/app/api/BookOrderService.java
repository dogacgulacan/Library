package com.company.library.app.api;

import com.company.library.entity.BookOrder;
import com.company.library.exceptions.AlreadyTakeBookException;
import com.company.library.exceptions.HasSameBookException;
import com.company.library.exceptions.IncorrectDatesException;
import com.company.library.exceptions.NullAmountException;

public interface BookOrderService {
    void saveOrderToForms(BookOrder bookOrder) throws AlreadyTakeBookException, IncorrectDatesException, HasSameBookException, NullAmountException;
}

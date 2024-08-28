package com.company.library.exceptions;

public class NullAmountException extends Exception{
    public NullAmountException() {
    }

    public NullAmountException(String message) {
        super(message);
    }
}

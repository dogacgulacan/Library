package com.company.library.exceptions;

public class AlreadyTakeBookException extends Exception{

    public AlreadyTakeBookException() {
    }

    public AlreadyTakeBookException(String s) {
        super(s);
    }
}

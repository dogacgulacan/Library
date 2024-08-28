package com.company.library.exceptions;

public class HasSameBookException extends Exception{
    public HasSameBookException() {
    }

    public HasSameBookException(String s) {
        super(s);
    }
}

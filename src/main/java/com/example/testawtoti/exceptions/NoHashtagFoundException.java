package com.example.testawtoti.exceptions;

public class NoHashtagFoundException extends RuntimeException {

    private String message;

    public NoHashtagFoundException() {}

    public NoHashtagFoundException(String msg) {
        super(msg);
        this.message = msg;
    }
}


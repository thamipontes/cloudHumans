package com.pro.pro.exception;

public class ApiEx {

    private final String message;

    public ApiEx(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

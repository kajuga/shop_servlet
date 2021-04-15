package com.fedorovs.shop.exception;

public class ValidationException extends IllegalArgumentException {

    public ValidationException(String s) {
        super(s);
    }
}
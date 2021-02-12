package com.jm.marketplace.exception;

public class GoodsCategoryNotFoundException extends RuntimeException {
    public GoodsCategoryNotFoundException() {
    }

    public GoodsCategoryNotFoundException(String message) {
        super(message);
    }

    public GoodsCategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}

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

    public GoodsCategoryNotFoundException(Throwable cause) {
        super(cause);
    }

    public GoodsCategoryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

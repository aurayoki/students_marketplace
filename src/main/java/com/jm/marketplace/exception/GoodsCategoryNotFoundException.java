package com.jm.marketplace.exception;

public class GoodsCategoryNotFound extends RuntimeException {
    public GoodsCategoryNotFound() {
    }

    public GoodsCategoryNotFound(String message) {
        super(message);
    }

    public GoodsCategoryNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodsCategoryNotFound(Throwable cause) {
        super(cause);
    }

    public GoodsCategoryNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

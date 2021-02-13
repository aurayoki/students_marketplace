package com.jm.marketplace.exception;

public class GoodsTypeNotFoundException extends RuntimeException {
    public GoodsTypeNotFoundException() {
    }

    public GoodsTypeNotFoundException(String message) {
        super(message);
    }

    public GoodsTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

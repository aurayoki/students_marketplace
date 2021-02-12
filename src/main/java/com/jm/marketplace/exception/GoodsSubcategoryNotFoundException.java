package com.jm.marketplace.exception;

public class GoodsSubcategoryNotFoundException  extends RuntimeException {
    public GoodsSubcategoryNotFoundException() {
    }

    public GoodsSubcategoryNotFoundException(String message) {
        super(message);
    }

    public GoodsSubcategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


}

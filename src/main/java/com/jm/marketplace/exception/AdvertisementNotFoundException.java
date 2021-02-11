package com.jm.marketplace.exception;

public class AdvertisementNotFoundException extends RuntimeException {
    public AdvertisementNotFoundException() {
    }

    public AdvertisementNotFoundException(String message) {
        super(message);
    }

    public AdvertisementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

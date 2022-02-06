package com.smkizilirmak.garage.exception;

import org.springframework.http.HttpStatus;

public class GarageApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public GarageApiException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

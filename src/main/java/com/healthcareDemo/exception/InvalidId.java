package com.healthcareDemo.exception;

public class InvalidId extends RuntimeException {
    public InvalidId(String message) {
        super(message);
    }
}

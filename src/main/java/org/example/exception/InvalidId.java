package org.example.exception;

public class InvalidId extends RuntimeException {
    public InvalidId(String message) {
        super(message);
    }
}

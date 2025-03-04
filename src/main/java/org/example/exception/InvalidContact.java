package org.example.exception;

public class InvalidContact extends RuntimeException {
    public InvalidContact(String message) {
        super(message);
    }
}

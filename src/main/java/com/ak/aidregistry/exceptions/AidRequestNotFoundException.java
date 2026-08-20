package com.ak.aidregistry.exceptions;

public class AidRequestNotFoundException extends RuntimeException {
    public AidRequestNotFoundException(String message) {
        super(message);
    }
}

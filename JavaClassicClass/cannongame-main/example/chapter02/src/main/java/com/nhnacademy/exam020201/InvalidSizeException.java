package com.nhnacademy.exam020201;

public class InvalidSizeException extends RuntimeException {
    public InvalidSizeException() {
        super();
    }

    public InvalidSizeException(String message) {
        super(message);
    }
}

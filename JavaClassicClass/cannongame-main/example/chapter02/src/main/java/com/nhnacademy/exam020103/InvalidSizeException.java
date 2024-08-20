package com.nhnacademy.exam020103;

public class InvalidSizeException extends RuntimeException {
    public InvalidSizeException() {
        super();
    }

    public InvalidSizeException(String message) {
        super(message);
    }
}

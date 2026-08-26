package com.example.Lab.OO.exception;

public class CarAlreadyRentedException extends RuntimeException {
    public CarAlreadyRentedException(String message) {
        super(message);
    }
}

package com.example.Lab.OO.exception;

public class CarNotRentedException extends RuntimeException {
    public CarNotRentedException(String message) {
        super(message);
    }
}

package com.example.Lab.OO.web;

import com.example.Lab.OO.exception.CarNotFoundException;
import com.example.Lab.OO.exception.CarAlreadyRentedException;
import com.example.Lab.OO.exception.CarNotRentedException;
import com.example.Lab.OO.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Gère correctement les URL introuvables (comme /h2-console ou favicon.ico) en 404
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResourceFound(NoResourceFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                "The requested resource was not found on this server.",
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCarNotFound(CarNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Corrigé : Retourne HttpStatus.CONFLICT (409) au lieu de NOT_FOUND (404)
    @ExceptionHandler(CarAlreadyRentedException.class)
    public ResponseEntity<ErrorResponse> handleCarAlreadyRented(CarAlreadyRentedException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Car Already Rented",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CarNotRentedException.class)
    public ResponseEntity<ErrorResponse> handleCarNotRented(CarNotRentedException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Car not Rented",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "An unexpected error occurred: " + ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

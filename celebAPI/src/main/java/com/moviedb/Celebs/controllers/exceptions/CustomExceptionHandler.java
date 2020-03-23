package com.moviedb.Celebs.controllers.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage> handleError(Exception ex) {
        ErrorMessage response = new ErrorMessage(ex.getMessage(), "");

        return new ResponseEntity<ErrorMessage>(response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

class ErrorMessage {
    private String message;
    private String details;

    public ErrorMessage(String message, String details) {
        super();
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}

package com.moviedb.Users.controllers.exceptions;

import com.moviedb.Users.models.errors.ApiException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage> handleError(ApiException ex) {
        ErrorMessage response = new ErrorMessage(ex.getMessage(), ex.getDetails());

        return new ResponseEntity<ErrorMessage>(response, new HttpHeaders(), ex.getStatus());
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

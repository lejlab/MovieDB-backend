package com.moviedb.UserPreferences.controllers.reviews.exceptions;

import com.moviedb.UserPreferences.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class ReviewNotFoundByIdException extends ApiException {
    public ReviewNotFoundByIdException(String id) {
        super(HttpStatus.NOT_FOUND,"Could not find review with ID = " + id + ".", "");
    }
}

package com.moviedb.UserPreferences.controllers.reviews.exceptions;

import com.moviedb.UserPreferences.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class ReviewNotFoundByUserIdException extends ApiException {
    public ReviewNotFoundByUserIdException(String id) {
        super(HttpStatus.NOT_FOUND,"Could not find review with user ID = " + id + ".", "");
    }
}

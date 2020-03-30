package com.moviedb.UserPreferences.controllers.reviews.exceptions;

import com.moviedb.UserPreferences.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class ReviewNotFoundByMovieIdException extends ApiException {
    public ReviewNotFoundByMovieIdException(String id) {
        super(HttpStatus.NOT_FOUND,"Could not find review with movie ID = " + id + ".", "");
    }
}

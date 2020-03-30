package com.moviedb.UserPreferences.controllers.comments.exceptions;

import com.moviedb.UserPreferences.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class CommentNotFoundByMovieIdException extends ApiException {
    public CommentNotFoundByMovieIdException(String id) {
        super(HttpStatus.NOT_FOUND,"Could not find comment with moview ID = " + id + ".", "");
    }
}

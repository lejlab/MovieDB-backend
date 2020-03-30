package com.moviedb.UserPreferences.controllers.comments.exceptions;

import com.moviedb.UserPreferences.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class CommentNotFoundByIdException extends ApiException {
    public CommentNotFoundByIdException(String id) {
        super(HttpStatus.NOT_FOUND,"Could not find comment with ID = " + id  + ".", "");
    }
}

package com.moviedb.UserPreferences.controllers.comments.exceptions;

import com.moviedb.UserPreferences.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class CommentNotFoundByUserIdException extends ApiException {
    public CommentNotFoundByUserIdException(String id) {
        super(HttpStatus.NOT_FOUND,"Could not find comment with user ID = " + id + ".", "");
    }
}

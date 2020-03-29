package com.moviedb.Users.controllers.users.exceptions;

import com.moviedb.Users.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException(Integer id) {
        super(HttpStatus.NOT_FOUND, "Could not find user with ID = " + id + ".", "");
    }
}

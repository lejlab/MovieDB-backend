package com.moviedb.Users.controllers.users.exceptions;

import com.moviedb.Users.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class UserNotFoundByUsernameException extends ApiException {
    public UserNotFoundByUsernameException(String username) {
        super(HttpStatus.NOT_FOUND, "Could not find user with username = " + username + ".", "");
    }
}

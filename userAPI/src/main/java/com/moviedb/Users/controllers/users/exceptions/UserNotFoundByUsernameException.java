package com.moviedb.Users.controllers.users.exceptions;

public class UserNotFoundByUsernameException extends RuntimeException {
    public UserNotFoundByUsernameException(String username) {
        super("Could not find user with username = " + username + ".");
    }
}

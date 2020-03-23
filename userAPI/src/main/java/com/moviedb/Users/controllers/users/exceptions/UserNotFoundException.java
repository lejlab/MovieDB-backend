package com.moviedb.Users.controllers.users.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super("Could not find user with ID = " + id + ".");
    }
}

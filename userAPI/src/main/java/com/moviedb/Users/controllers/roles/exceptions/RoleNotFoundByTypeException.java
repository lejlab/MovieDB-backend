package com.moviedb.Users.controllers.roles.exceptions;

public class RoleNotFoundByTypeException extends RuntimeException {
    public RoleNotFoundByTypeException(String type){
        super("Could not find role with type = " + type + ".");
    }
}


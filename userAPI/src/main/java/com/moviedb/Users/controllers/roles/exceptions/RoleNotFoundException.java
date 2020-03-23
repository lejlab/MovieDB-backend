package com.moviedb.Users.controllers.roles.exceptions;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(Integer id){
        super("Could not find role with ID = " + id + ".");
    }
}

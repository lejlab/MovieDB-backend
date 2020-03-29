package com.moviedb.Users.controllers.roles.exceptions;

import com.moviedb.Users.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class RoleNotFoundException extends ApiException {
    public RoleNotFoundException(Integer id){
        super(HttpStatus.NOT_FOUND, "Could not find role with ID = " + id + ".", "");
    }
}

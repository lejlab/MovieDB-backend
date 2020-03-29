package com.moviedb.Users.controllers.roles.exceptions;

import com.moviedb.Users.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class RoleNotFoundByTypeException extends ApiException {
    public RoleNotFoundByTypeException(String type){
        super(HttpStatus.NOT_FOUND, "Could not find role with type = " + type + ".", "");
    }
}


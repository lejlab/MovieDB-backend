package com.moviedb.Celebs.controllers.celebs.exceptions;

import com.moviedb.Celebs.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class CelebTypeNotFoundException extends ApiException {
    public CelebTypeNotFoundException(String type) {
        super(HttpStatus.NOT_FOUND, "Could not find celeb with type = " + type + ".", "");
    }
}

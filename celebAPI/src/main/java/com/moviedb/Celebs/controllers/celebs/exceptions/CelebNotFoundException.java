package com.moviedb.Celebs.controllers.celebs.exceptions;

import com.moviedb.Celebs.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class CelebNotFoundException extends ApiException {
    public CelebNotFoundException(Integer id) {
        super(HttpStatus.NOT_FOUND, "Could not find celeb with ID = " + id + ".", "");
    }
}

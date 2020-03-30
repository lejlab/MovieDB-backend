package com.moviedb.Celebs.controllers.movieCelebs.expceptions;

import com.moviedb.Celebs.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class MovieCelebsTypeNotFoundException extends ApiException {
    public MovieCelebsTypeNotFoundException(String type) {
        super(HttpStatus.NOT_FOUND, "Could not find movie celeb with type = " + type + ".", "");
    }
}
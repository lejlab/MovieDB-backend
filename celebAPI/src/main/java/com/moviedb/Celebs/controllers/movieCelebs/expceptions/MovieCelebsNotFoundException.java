package com.moviedb.Celebs.controllers.movieCelebs.expceptions;

import com.moviedb.Celebs.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class MovieCelebsNotFoundException extends ApiException {
    public MovieCelebsNotFoundException(Integer id) {
        super(HttpStatus.NOT_FOUND, "Could not find movie celeb with id = " + id + ".", "");
    }
}

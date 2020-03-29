package com.moviedb.Movies.controllers.genres.exceptions;

import com.moviedb.Movies.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class GenreNotFoundException extends ApiException {
    public GenreNotFoundException(Integer id) {
        super(HttpStatus.NOT_FOUND,"Could not find genre with ID = " + id + ".", "");
    }
}

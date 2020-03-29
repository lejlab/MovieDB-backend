package com.moviedb.Movies.controllers.movies.exceptions;

import com.moviedb.Movies.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class MovieNotFoundException extends ApiException {
    public MovieNotFoundException(Integer id) {
        super(HttpStatus.NOT_FOUND,"Could not find movie with ID = " + id + ".", "");
    }
}

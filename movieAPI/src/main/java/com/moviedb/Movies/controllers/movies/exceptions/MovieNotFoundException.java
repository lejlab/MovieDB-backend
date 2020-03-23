package com.moviedb.Movies.controllers.movies.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Integer id) {
        super("Could not find movie with ID = " + id + ".");
    }
}

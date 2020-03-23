package com.moviedb.Movies.controllers.genres.exceptions;

public class GenreNotFoundException extends RuntimeException {
    public GenreNotFoundException(Integer id) {
        super("Could not find genre with ID = " + id + ".");
    }
}

package com.moviedb.Movies.controllers.genreMovies.exceptions;

public class GenreMovieNotFoundException extends RuntimeException {
    public GenreMovieNotFoundException(Integer id) {
        super("Could not find genreMovie with ID = " + id + ".");
    }
}

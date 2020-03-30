package com.moviedb.Movies.controllers.genreMovies.exceptions;

import com.moviedb.Movies.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class GenreMovieNotFoundByGenreIdException extends ApiException {
    public GenreMovieNotFoundByGenreIdException(Integer id) {
        super(HttpStatus.NOT_FOUND,"Could not find genreMovie with movie ID = " + id + ".", "");
    }
}

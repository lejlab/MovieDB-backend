package com.moviedb.Celebs.controllers.movieCelebs.expceptions;


public class MovieCelebNotFoundByMovieIdException extends RuntimeException {
    public MovieCelebNotFoundByMovieIdException(Integer movieId) {
        super("Could not find movie celeb with movie id = " + movieId + ".");
    }
}
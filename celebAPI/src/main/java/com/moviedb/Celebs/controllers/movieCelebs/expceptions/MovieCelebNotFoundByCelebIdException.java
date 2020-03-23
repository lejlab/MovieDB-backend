package com.moviedb.Celebs.controllers.movieCelebs.expceptions;

public class MovieCelebNotFoundByCelebIdException extends RuntimeException {
    public MovieCelebNotFoundByCelebIdException(Integer celebId) {
        super("Could not find movie celeb with celeb id = " + celebId + ".");
    }
}

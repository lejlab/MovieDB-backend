package com.moviedb.Celebs.controllers.movieCelebs.expceptions;

public class MovieCelebsNotFoundException extends RuntimeException {
    public MovieCelebsNotFoundException(Integer id) {
        super("Could not find movie celeb with id = " + id + ".");
    }
}

package com.moviedb.Celebs.controllers.celebs.exceptions;

public class CelebNotFoundException extends RuntimeException {
    public CelebNotFoundException(Integer id) {
        super("Could not find celeb with ID = " + id + ".");
    }
}

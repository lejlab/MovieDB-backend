package com.moviedb.Celebs.controllers.celebJobs.exceptions;

public class CelebJobNotFoundByCelebIdException extends RuntimeException {
    public CelebJobNotFoundByCelebIdException(Integer celebId) {
        super("Could not find celeb job with celeb id = " + celebId + ".");
    }
}

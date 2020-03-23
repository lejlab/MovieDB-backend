package com.moviedb.Celebs.controllers.celebJobs.exceptions;

public class CelebJobNotFoundByJobIdException extends RuntimeException {
    public CelebJobNotFoundByJobIdException(Integer jobId) {
        super("Could not find celeb job with job id = " + jobId + ".");
    }
}

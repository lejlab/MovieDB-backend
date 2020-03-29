package com.moviedb.Celebs.controllers.celebJobs.exceptions;

public class CelebJobsNotFoundException extends RuntimeException {
    public CelebJobsNotFoundException(Integer id) {
        super("Could not find celeb job with id = " + id + ".");
    }
}

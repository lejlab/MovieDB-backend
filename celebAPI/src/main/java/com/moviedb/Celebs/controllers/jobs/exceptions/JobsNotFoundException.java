package com.moviedb.Celebs.controllers.jobs.exceptions;

public class JobsNotFoundException extends RuntimeException {
    public JobsNotFoundException(Integer id) {
        super("Could not find job with ID = " + id + ".");
    }
}
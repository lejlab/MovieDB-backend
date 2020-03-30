package com.moviedb.Celebs.controllers.celebJobs.exceptions;

import com.moviedb.Celebs.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class CelebJobsNotFoundException extends ApiException {
    public CelebJobsNotFoundException(Integer id) {
        super(HttpStatus.NOT_FOUND, "Could not find celeb job with id = " + id + ".", "");
    }
}

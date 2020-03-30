package com.moviedb.Celebs.controllers.jobs.exceptions;

import com.moviedb.Celebs.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class JobsNotFoundException extends ApiException {
    public JobsNotFoundException(Integer id) {
        super(HttpStatus.NOT_FOUND, "Could not find job with ID = " + id + ".", "");
    }
}
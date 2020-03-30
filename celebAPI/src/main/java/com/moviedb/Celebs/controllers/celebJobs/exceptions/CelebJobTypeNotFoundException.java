package com.moviedb.Celebs.controllers.celebJobs.exceptions;

import com.moviedb.Celebs.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class CelebJobTypeNotFoundException extends ApiException {
    public  CelebJobTypeNotFoundException(String type) {
        super(HttpStatus.NOT_FOUND, "Could not find celeb job with type = " + type + ".", "");
    }
}
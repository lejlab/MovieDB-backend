package com.moviedb.Users.controllers.subscriptions.exceptions;

import com.moviedb.Users.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class SubscriptionNotFoundByOwnerIdException extends ApiException {
    public SubscriptionNotFoundByOwnerIdException(Integer id) {
        super(HttpStatus.NOT_FOUND, "Could not find subscription with owner ID = " + id + ".", "");
    }
}

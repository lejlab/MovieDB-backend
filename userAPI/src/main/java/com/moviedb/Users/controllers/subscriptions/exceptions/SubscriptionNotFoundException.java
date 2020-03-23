package com.moviedb.Users.controllers.subscriptions.exceptions;

public class SubscriptionNotFoundException extends RuntimeException {
    public SubscriptionNotFoundException(Integer id) {
        super("Could not find subscription with ID = " + id + ".");
    }
}

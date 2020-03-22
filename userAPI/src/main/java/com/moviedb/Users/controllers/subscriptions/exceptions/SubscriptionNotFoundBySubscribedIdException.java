package com.moviedb.Users.controllers.subscriptions.exceptions;

public class SubscriptionNotFoundBySubscribedIdException extends RuntimeException {
    public SubscriptionNotFoundBySubscribedIdException(Integer id) {
        super("Could not find subscription with subscribed ID = " + id + ".");
    }
}

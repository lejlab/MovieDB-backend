package com.moviedb.Users.controllers.subscriptions.exceptions;

public class SubscriptionNotFoundByOwnerIdException extends  RuntimeException {
    public SubscriptionNotFoundByOwnerIdException(Integer id) {
        super("Could not find subscription with owner ID = " + id + ".");
    }
}

package com.moviedb.Users.controllers.notifications.exceptions;

public class NotificationNotFoundByOwnerIdException extends RuntimeException {
    public NotificationNotFoundByOwnerIdException(Integer ownerId){
        super("Could not find notification with owner ID = " + ownerId + ".");
    }
}

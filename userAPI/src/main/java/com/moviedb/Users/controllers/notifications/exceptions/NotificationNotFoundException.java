package com.moviedb.Users.controllers.notifications.exceptions;

public class NotificationNotFoundException extends RuntimeException {
    public NotificationNotFoundException(Integer id){
        super("Could not find notification with ID = " + id + ".");
    }
}

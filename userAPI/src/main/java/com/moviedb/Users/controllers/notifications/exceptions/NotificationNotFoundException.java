package com.moviedb.Users.controllers.notifications.exceptions;

import com.moviedb.Users.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class NotificationNotFoundException extends ApiException {
    public NotificationNotFoundException(Integer id){
        super(HttpStatus.NOT_FOUND, "Could not find notification with ID = " + id + ".", "");
    }
}

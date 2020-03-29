package com.moviedb.Users.controllers.notifications.exceptions;

import com.moviedb.Users.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class NotificationNotFoundByOwnerIdException extends ApiException {
    public NotificationNotFoundByOwnerIdException(Integer ownerId){
        super(HttpStatus.NOT_FOUND, "Could not find notification with owner ID = " + ownerId + ".", "");
    }
}

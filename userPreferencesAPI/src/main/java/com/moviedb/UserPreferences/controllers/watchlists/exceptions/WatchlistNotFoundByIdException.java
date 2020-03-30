package com.moviedb.UserPreferences.controllers.watchlists.exceptions;

import com.moviedb.UserPreferences.models.errors.ApiException;
import org.springframework.http.HttpStatus;

public class WatchlistNotFoundByIdException extends ApiException {
    public WatchlistNotFoundByIdException(String id, String type) {
        super(HttpStatus.NOT_FOUND,"Could not find watchlist with ID = " + id + " and type = " + type + ".", "");
    }
}

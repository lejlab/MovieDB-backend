package com.moviedb.Celebs.controllers.celebs.exceptions;

import java.util.Date;

public class CelebNotFoundByDateOfBirthException extends RuntimeException {
    public CelebNotFoundByDateOfBirthException(Date date) {
        super("Could not find celeb with date of birth = " + date + ".");
    }
}

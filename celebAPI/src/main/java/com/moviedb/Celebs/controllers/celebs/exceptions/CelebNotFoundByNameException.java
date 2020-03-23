package com.moviedb.Celebs.controllers.celebs.exceptions;

public class CelebNotFoundByNameException extends RuntimeException {
    public CelebNotFoundByNameException (String name){
        super("Could not find role with type = " + name + ".");
    }
}
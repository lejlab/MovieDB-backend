package com.moviedb.Movies.controllers;

import com.moviedb.Movies.models.Genre;
import com.moviedb.Movies.repositories.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class GenresController {
    @Autowired
    GenresRepository genresRepository;

    @GetMapping("/genres")
    public List<Genre> find(){
        return genresRepository.findAll();
    }
/*
    @GetMapping("/movies/{id}")
    public List<Movie> findByOwnerUserId(@PathVariable("id") String id){
        Integer userOwnerId = parseInt(id);
        return moviesRepository.findByOwnerUserId(userOwnerId);
    }*/
}
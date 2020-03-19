package com.moviedb.Movies.controllers;

import com.moviedb.Movies.models.Movie;
import com.moviedb.Movies.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.moviedb.Movies.models.Movie;
import com.moviedb.Movies.repositories.MoviesRepository;


@RestController
public class MoviesController {
    @Autowired
    MoviesRepository moviesRepository;

    @GetMapping("/movies")
    public List<Movie> find(){
        return moviesRepository.findAll();
    }
    
    @GetMapping("/")
    public String index(){
        return ("movies, movies/{title}}");
    }


    @GetMapping("/movies/{title}")
    public Movie findByTitle(@PathVariable("title") String title){
        return moviesRepository.findByTitle(title);
    }
}

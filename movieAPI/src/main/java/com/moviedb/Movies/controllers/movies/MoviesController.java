package com.moviedb.Movies.controllers.movies;

import com.moviedb.Movies.controllers.movies.exceptions.MovieNotFoundException;
import com.moviedb.Movies.models.Genre;
import com.moviedb.Movies.models.Movie;
import com.moviedb.Movies.repositories.MoviesRepository;
import com.moviedb.Movies.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.moviedb.Movies.models.Movie;
import com.moviedb.Movies.repositories.MoviesRepository;


@RestController
public class MoviesController {
    @Autowired
    MoviesService moviesService;

    @GetMapping("/")
    public String index(){
        return ("movies, movies/{id}, genres, genres/{id}");
    }

    @GetMapping("/movies")
    public List<Movie> find(){
        return moviesService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie findById(@PathVariable("id") Integer id){
        return moviesService.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @PostMapping("/movies")
    public Movie newMovie(@RequestBody Movie newMovie) {
        return moviesService.addNewMovie(newMovie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable Integer id){ moviesService.deleteMovieById(id); }

    @PutMapping("/movies/{id}")
    public Movie editMovie(@RequestBody Movie newData, @PathVariable("id") Integer id) {
        return moviesService.editMovieById(newData,id);
    }
}

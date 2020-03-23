package com.moviedb.Movies.controllers.genreMovies;

import com.moviedb.Movies.controllers.genreMovies.exceptions.GenreMovieNotFoundException;
import com.moviedb.Movies.models.GenreMovie;
import com.moviedb.Movies.repositories.GenreMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GenreMoviesController {
    @Autowired
    GenreMoviesRepository genreMoviesRepository;

    @GetMapping("/genreMovies")
    public List<GenreMovie> find(){
        return genreMoviesRepository.findAll();
    }

    @PostMapping("/genreMovies")
    public GenreMovie newGenreMovie(@RequestBody GenreMovie newSubscribe) {
        return genreMoviesRepository.save(newSubscribe);
    }

    @GetMapping("/genreMovies/{id}")
    public Object findById(@PathVariable(value = "id") Integer id) {
        return genreMoviesRepository.findById(id).orElseThrow(() -> new GenreMovieNotFoundException(id));
    }

    @DeleteMapping("/genreMovies/{id}")
    public void deleteGenreMovie(@PathVariable Integer id) {
        genreMoviesRepository.deleteById(id);
    }
}

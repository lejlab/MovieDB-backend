package com.moviedb.Movies.controllers.genreMovies;

import com.moviedb.Movies.controllers.genreMovies.exceptions.GenreMovieNotFoundByGenreIdException;
import com.moviedb.Movies.controllers.genreMovies.exceptions.GenreMovieNotFoundByMovieIdException;
import com.moviedb.Movies.controllers.genreMovies.exceptions.GenreMovieNotFoundException;
import com.moviedb.Movies.models.GenreMovie;
import com.moviedb.Movies.repositories.GenreMoviesRepository;
import com.moviedb.Movies.services.GenreMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GenreMoviesController {
    @Autowired
    private GenreMoviesService genreMoviesService;

    @GetMapping(value = "/genreMovies")
    public List<GenreMovie> getAllGenreMovies(){
        return genreMoviesService.getAllGenreMovies();
    }

    @PostMapping("/genreMovies")
    public GenreMovie addGenreMovie(@RequestBody GenreMovie newGenreMovie) {
        return genreMoviesService.addGenreMovie(newGenreMovie);
    }

    @GetMapping("/genreMovies/{id}")
    public Object findGenreMovieById(@PathVariable(value = "id") Integer id) {
        return genreMoviesService.findGenreMovieById(id).orElseThrow(() -> new GenreMovieNotFoundException(id));
    }

    @DeleteMapping("/genreMovies/{id}")
    public void deleteGenreMovie(@PathVariable Integer id) {
        genreMoviesService.deleteGenreMovie(id);
    }

    @GetMapping("/genreMovies/genre/{id}")
    public Object findByGenreId(@PathVariable(value = "id") Integer id){
       return genreMoviesService.getOneByGenreId(id).orElseThrow(() -> new GenreMovieNotFoundByGenreIdException(id));
    }

    @GetMapping("/genreMovies/movie/{id}")
    public Object findByMovieId(@PathVariable(value = "id") Integer id){
        return genreMoviesService.getOneByMovieId(id).orElseThrow(() -> new GenreMovieNotFoundByMovieIdException(id));
    }
}

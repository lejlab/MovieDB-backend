package com.moviedb.Movies.controllers.movies;

import com.moviedb.Movies.controllers.movies.exceptions.MovieNotFoundException;
import com.moviedb.Movies.models.Genre;
import com.moviedb.Movies.models.Movie;
import com.moviedb.Movies.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.moviedb.Movies.models.Movie;
import com.moviedb.Movies.repositories.MoviesRepository;


@RestController
public class MoviesController {
    @Autowired
    MoviesRepository moviesRepository;

    @GetMapping("/")
    public String index(){
        return ("movies, movies/{id}, genres, genres/{id}");
    }

    @GetMapping("/movies")
    public List<Movie> find(){
        return moviesRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie findById(@PathVariable("id") Integer id){
        return moviesRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @PostMapping("/movies")
    public Movie newMovie(@RequestBody Movie newMovie) {
        return moviesRepository.save(newMovie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable Integer id){ moviesRepository.deleteById(id); }

    @PutMapping("/movies/{id}")
    public Movie editMovie(@RequestBody Movie newData, @PathVariable("id") Integer id) {
        return moviesRepository.findById(id)
                .map(movie -> {
                    movie.setTitle(newData.getTitle());
                    movie.setReleaseDate(newData.getReleaseDate());
                    movie.setBoxOffice(newData.getBoxOffice());
                    movie.setGenres(newData.getGenres());
                    System.out.println(movie.toString());
                    return moviesRepository.save(movie);
                }).orElseGet(() -> moviesRepository.save(newData));
    }
}

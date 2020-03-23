package com.moviedb.Movies.controllers.genres;

import com.moviedb.Movies.controllers.genres.exceptions.GenreNotFoundException;
import com.moviedb.Movies.controllers.movies.exceptions.MovieNotFoundException;
import com.moviedb.Movies.models.Genre;
import com.moviedb.Movies.repositories.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class GenresController {
    @Autowired
    GenresRepository genresRepository;

    @GetMapping("/genres")
    public List<Genre> find(){
        return genresRepository.findAll();
    }

    @GetMapping("/genres/{id}")
    public Genre findById(@PathVariable("id") Integer id){
        return genresRepository.findById(id).orElseThrow(() -> new GenreNotFoundException(id));
    }

    @PostMapping("/genres")
    public Genre newGenre(@RequestBody Genre newGenre) {
        return genresRepository.save(newGenre);
    }

    @DeleteMapping("/genres/{id}")
    public void deleteGenre(@PathVariable Integer id){ genresRepository.deleteById(id); }

}
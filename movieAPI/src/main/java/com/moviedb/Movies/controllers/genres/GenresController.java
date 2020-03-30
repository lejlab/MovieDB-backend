package com.moviedb.Movies.controllers.genres;

import com.moviedb.Movies.controllers.genres.exceptions.GenreNotFoundException;
import com.moviedb.Movies.models.Genre;
import com.moviedb.Movies.models.Movie;
import com.moviedb.Movies.services.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GenresController {
    @Autowired
    GenresService genresService;

    @GetMapping("/genres")
    public List<Genre> getAllGenres(){
        return genresService.getAllGenres();
    }

    @GetMapping("/genres/{id}")
    public Genre findById(@PathVariable("id") Integer id){
        return genresService.findGenreById(id).orElseThrow(() -> new GenreNotFoundException(id));
    }

    @PostMapping("/genres")
    public Genre newGenre(@RequestBody Genre newGenre) {
        return genresService.addNewGenre(newGenre);
    }

    @DeleteMapping("/genres/{id}")
    public void deleteGenre(@PathVariable Integer id){ genresService.deleteGenreById(id);
    }

    @PutMapping("/genres/{id}")
    public Genre editGenre(@RequestBody Genre newData, @PathVariable("id") Integer id) {
        return genresService.editGenreById(newData, id);
    }
}
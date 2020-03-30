package com.moviedb.Movies.services;

import com.moviedb.Movies.models.GenreMovie;
import com.moviedb.Movies.repositories.GenreMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreMoviesService {
    @Autowired
    private GenreMoviesRepository genreMoviesRepository;

    public List<GenreMovie> getAllGenreMovies() {
        return genreMoviesRepository.findAll();
    }

    public GenreMovie addGenreMovie(GenreMovie newGenreMovie) {
        return genreMoviesRepository.save(newGenreMovie);
    }

    public Optional<GenreMovie> findGenreMovieById(Integer id) {
        return genreMoviesRepository.findById(id);
    }

    public void deleteGenreMovie(Integer id) {
        genreMoviesRepository.deleteById(id);
    }

    public Optional<List<GenreMovie>> getOneByGenreId(Integer id) {
        return genreMoviesRepository.findByGenreId(id);
    }

    public Optional<List<GenreMovie>> getOneByMovieId(Integer id) {
        return genreMoviesRepository.findByMovieId(id);
    }
}
package com.moviedb.Movies.services;

import com.moviedb.Movies.models.Genre;
import com.moviedb.Movies.models.Movie;
import com.moviedb.Movies.repositories.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenresService {
    @Autowired
    private GenresRepository genresRepository;

    public List<Genre> getAllGenres(){
        return genresRepository.findAll();
    }

    public Optional<Genre> findGenreById(Integer id){
        return genresRepository.findById(id);
    }

    public Genre addNewGenre(Genre newGenre) {
        return genresRepository.save(newGenre);
    }

    public void deleteGenreById(Integer id){
        genresRepository.deleteById(id);
    }

    public Genre editGenreById(Genre newData, Integer id) {
        return genresRepository.findById(id)
                .map(genre -> {
                    genre.setName(newData.getName());
                    genre.setMovies(newData.getMovies());
                    System.out.println(genre.toString());
                    return genresRepository.save(genre);
                }).orElseGet(() -> genresRepository.save(newData));
    }
}
package com.moviedb.Movies.services;

import com.moviedb.Movies.models.Movie;
import com.moviedb.Movies.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movie> getAllMovies(){
        return moviesRepository.findAll();
    }

    public Optional<Movie> findById(Integer id){
        return moviesRepository.findById(id);
    }

    public Movie addNewMovie(Movie newMovie) {
        return moviesRepository.save(newMovie);
    }

    public void deleteMovieById(Integer id){
        moviesRepository.deleteById(id);
    }

    public Movie editMovieById(Movie newData, Integer id) {
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

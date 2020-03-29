package com.moviedb.Celebs.services;

import com.moviedb.Celebs.models.CelebJobs;
import com.moviedb.Celebs.models.MovieCeleb;
import com.moviedb.Celebs.repositories.MovieCelebsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieCelebService {
    @Autowired
    MovieCelebsRepository movieCelebsRepository;

    public List<MovieCeleb> getAll() {
        return movieCelebsRepository.findAll();
    }

    public Optional<MovieCeleb> getOneById(Integer id) {
        return movieCelebsRepository.findById(id);
    }

    public List<MovieCeleb> getAllByMovieId(Integer id) {
        return movieCelebsRepository.findByMovieId(id);
    }

    public List<MovieCeleb> getAllByCelebId(Integer id) {
        return movieCelebsRepository.findByCelebId(id);
    }

    public MovieCeleb addOne(MovieCeleb movieCeleb) {
        return movieCelebsRepository.save(movieCeleb);
    }

    public MovieCeleb editOne(MovieCeleb newData, Integer id) {
        return movieCelebsRepository.findById(id)
                .map(movieCeleb -> {
                    movieCeleb.setMovieId(newData.getMovieId());
                    movieCeleb.setCeleb(newData.getCeleb());
                    return movieCelebsRepository.save(movieCeleb);
                }).orElseGet(() -> movieCelebsRepository.save(newData));
    }

    public void removeOne(Integer id) {
        movieCelebsRepository.deleteById(id);
    }
}

package com.moviedb.Movies.repositories;

import com.moviedb.Movies.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.moviedb.Movies.models.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {
    Optional<List<Movie>> findByTitle(String title);
}
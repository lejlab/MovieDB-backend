package com.moviedb.Movies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.moviedb.Movies.models.Movie;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {
}
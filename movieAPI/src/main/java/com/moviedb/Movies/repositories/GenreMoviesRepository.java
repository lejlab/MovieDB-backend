package com.moviedb.Movies.repositories;

import com.moviedb.Movies.models.Genre;
import com.moviedb.Movies.models.GenreMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreMoviesRepository extends JpaRepository<GenreMovie, Integer> {
}
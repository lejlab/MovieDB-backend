package com.moviedb.Movies.repositories;


import com.moviedb.Movies.models.GenreMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreMoviesRepository extends JpaRepository<GenreMovie, Integer> {
    @Query(value = "SELECT s from GenreMovie s WHERE genre_id = :id")
    Optional<List<GenreMovie>> findByGenreId(@Param("id") Integer id);
    @Query(value =  "SELECT s from GenreMovie s WHERE movie_id = :id")
    Optional<List<GenreMovie>> findByMovieId(@Param("id") Integer id);
}

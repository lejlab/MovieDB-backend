package com.moviedb.Movies.repositories;

import com.moviedb.Movies.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenresRepository extends JpaRepository<Genre, Integer> {
    Optional<List<Genre>> findByName(String name);
}
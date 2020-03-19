package com.moviedb.Movies.repositories;

import com.moviedb.Movies.models.Genre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepository extends JpaRepository<Genre, Integer> {
    Genre findByName(String name);
}
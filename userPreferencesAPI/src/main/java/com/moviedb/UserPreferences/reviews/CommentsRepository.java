package com.moviedb.UserPreferences.reviews;

import com.moviedb.UserPreferences.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "SELECT s from Comment s WHERE user_id = :id")
    Optional<List<Comment>> findByUserId(@Param("id") Integer id);
    @Query(value = "SELECT s from Comment s WHERE movie_id = :id")
    Optional<List<Comment>> findByMovieId(@Param("id") Integer id);
}

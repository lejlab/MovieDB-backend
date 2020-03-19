package com.moviedb.UserPreferences.repositories;

import com.moviedb.UserPreferences.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByUserId(Integer userId);
    List<Comment> findByMovieId(Integer movieId);
}

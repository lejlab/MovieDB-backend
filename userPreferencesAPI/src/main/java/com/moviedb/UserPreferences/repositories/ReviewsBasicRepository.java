package com.moviedb.UserPreferences.repositories;

import com.moviedb.UserPreferences.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsBasicRepository extends JpaRepository<Review, Integer> {
    List<Review> findByUserId(Integer userId);
    List<Review> findByMovieId(Integer movieId);
    List<Review> findAllByOrderByGradeAsc();
    List<Review> findAllByOrderByGradeDesc();
}

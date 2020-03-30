package com.moviedb.UserPreferences.reviews;

import com.moviedb.UserPreferences.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewsBasicRepository extends JpaRepository<Review, Integer> {
    @Query(value = "SELECT s from Review s WHERE user_id = :id")
    Optional<List<Review>> findByUserId(@Param("id") Integer userId);
    @Query(value = "SELECT s from Review s WHERE movie_id = :id")
    Optional<List<Review>> findByMovieId(@Param("id") Integer movieId);
    List<Review> findAllByOrderByGradeAsc();
    List<Review> findAllByOrderByGradeDesc();
}

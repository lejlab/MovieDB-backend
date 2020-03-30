package com.moviedb.UserPreferences.reviews;

import com.moviedb.UserPreferences.models.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsCustomRepository {
    public List<Review> findTopNByGradeAsc(Integer limit);
    public List<Review> findTopNByGradeDesc(Integer limit);
}

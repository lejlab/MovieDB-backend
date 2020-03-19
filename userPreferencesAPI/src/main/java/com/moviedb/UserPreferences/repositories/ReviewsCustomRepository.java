package com.moviedb.UserPreferences.repositories;

import com.moviedb.UserPreferences.models.Review;
import java.util.List;

public interface ReviewsCustomRepository {
    public List<Review> findTopNByGradeAsc(Integer limit);
    public List<Review> findTopNByGradeDesc(Integer limit);
}

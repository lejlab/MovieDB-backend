package com.moviedb.UserPreferences.reviews;

import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends ReviewsBasicRepository, ReviewsCustomRepository { }

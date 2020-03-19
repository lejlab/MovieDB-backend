package com.moviedb.UserPreferences.repositories;


import com.moviedb.UserPreferences.models.Review;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ReviewsCustomRepositoryImpl implements ReviewsCustomRepository {
    private final ReviewsBasicRepository reviewsBasicRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public ReviewsCustomRepositoryImpl(ReviewsBasicRepository reviewsBasicRepository) {
        this.reviewsBasicRepository = reviewsBasicRepository;
    }

    @Override
    public List<Review> findTopNByGradeAsc(Integer limit) {
        return entityManager.createQuery("SELECT r FROM Review r ORDER BY r.grade", Review.class).setMaxResults(limit).getResultList();
    };
    public List<Review> findTopNByGradeDesc(Integer limit) {
        return entityManager.createQuery("SELECT r FROM Review r ORDER BY r.grade DESC", Review.class).setMaxResults(limit).getResultList();
    }

}

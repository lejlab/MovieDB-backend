package com.moviedb.UserPreferences.services;

import com.moviedb.UserPreferences.models.Review;
import com.moviedb.UserPreferences.reviews.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
public class ReviewsService {
    @Autowired
    ReviewsRepository reviewsRepository;

    public List<Review> findAll(String top, String orderBy) {
        if (top != null) {
            Integer N = parseInt(top);

            if (orderBy != null) {
                if (orderBy.toLowerCase().equals("asc")) return reviewsRepository.findTopNByGradeAsc(N);
                else if (orderBy.toLowerCase().equals("desc")) return reviewsRepository.findTopNByGradeDesc(N);
            }
            return reviewsRepository.findTopNByGradeDesc(N);
        } else if (orderBy != null) {
            if (orderBy.toLowerCase().equals("asc")) return reviewsRepository.findAllByOrderByGradeAsc();
            else if (orderBy.toLowerCase().equals("desc")) return reviewsRepository.findAllByOrderByGradeDesc();

            return null;
        }
        return reviewsRepository.findAll();
    }

    public Optional<Review> findById(String id) {
        Integer ID = parseInt(id);
        return reviewsRepository.findById(ID);
    }

    public Optional<List<Review>> findByMovieId(String id) {
        Integer ID = parseInt(id);
        return reviewsRepository.findByMovieId(ID);
    }

    public Optional<List<Review>> findByUserId(String id) {
        Integer ID = parseInt(id);
        return reviewsRepository.findByUserId(ID);
    }

    public void deleteById(String id) {
        Integer ID = parseInt(id);
        reviewsRepository.deleteById(ID);
    }
}

package com.moviedb.UserPreferences.services;

import com.moviedb.UserPreferences.models.Review;
import com.moviedb.UserPreferences.repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class ReviewsService {
    @Autowired
    ReviewsRepository reviewsRepository;

    public List<Review> findAll(String top, String orderBy){
        if (top != null) {
            Integer N = parseInt(top);

            if (orderBy != null) {
                if (orderBy.toLowerCase().equals("asc")) return reviewsRepository.findTopNByGradeAsc(N);
                else if (orderBy.toLowerCase().equals("desc")) return reviewsRepository.findTopNByGradeDesc(N);
            }
            return reviewsRepository.findTopNByGradeDesc(N);
        }
        else if (orderBy != null) {
            if (orderBy.toLowerCase().equals("asc")) return reviewsRepository.findAllByOrderByGradeAsc();
            else if (orderBy.toLowerCase().equals("desc")) return reviewsRepository.findAllByOrderByGradeDesc();

            return null;
        }
        return reviewsRepository.findAll();
    }

    public Object findById(String id, String type){
        Integer ID = parseInt(id);

        if (type == null){
            return reviewsRepository.findById(ID);
        }
        else if (type.toLowerCase().equals("movie")){
            return reviewsRepository.findByMovieId(ID);
        }
        else if (type.toLowerCase().equals("user")){
            return reviewsRepository.findByUserId(ID);
        }

        return null;
    }
}

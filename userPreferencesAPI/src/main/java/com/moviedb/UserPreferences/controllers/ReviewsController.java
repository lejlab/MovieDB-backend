package com.moviedb.UserPreferences.controllers;

import com.moviedb.UserPreferences.models.Review;
import com.moviedb.UserPreferences.repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class ReviewsController {
    @Autowired
    ReviewsRepository reviewsRepository;

    @GetMapping("/reviews")
    public List<Review> find(@RequestParam(required = false) String top, @RequestParam(required = false) String orderBy){
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

    @GetMapping("/reviews/{id}")
    public Object findById(@PathVariable(value = "id") String id, @RequestParam(required = false) String type){
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

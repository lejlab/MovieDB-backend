package com.moviedb.UserPreferences.controllers.reviews;


import com.moviedb.UserPreferences.controllers.reviews.exceptions.ReviewNotFoundByIdException;
import com.moviedb.UserPreferences.models.Review;;
import com.moviedb.UserPreferences.services.ReviewsService;
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
    ReviewsService reviewsService;

    @GetMapping("/reviews")
    public List<Review> find(@RequestParam(required = false) String top, @RequestParam(required = false) String orderBy){
        return reviewsService.findAll(top,orderBy);
    }

    @GetMapping("/reviews/{id}")
    public Object findById(@PathVariable(value = "id") String id, @RequestParam(required = false) String type){
        Object result = reviewsService.findById(id,type);
        if(result == null)
            throw new ReviewNotFoundByIdException(id, type);
        else
            return result;
    }
}

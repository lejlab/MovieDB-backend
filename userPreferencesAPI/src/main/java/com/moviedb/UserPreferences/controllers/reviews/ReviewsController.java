package com.moviedb.UserPreferences.controllers.reviews;


import com.moviedb.UserPreferences.controllers.comments.exceptions.CommentNotFoundByIdException;
import com.moviedb.UserPreferences.controllers.comments.exceptions.CommentNotFoundByMovieIdException;
import com.moviedb.UserPreferences.controllers.comments.exceptions.CommentNotFoundByUserIdException;
import com.moviedb.UserPreferences.controllers.reviews.exceptions.ReviewNotFoundByIdException;
import com.moviedb.UserPreferences.controllers.reviews.exceptions.ReviewNotFoundByMovieIdException;
import com.moviedb.UserPreferences.controllers.reviews.exceptions.ReviewNotFoundByUserIdException;
import com.moviedb.UserPreferences.models.Review;;
import com.moviedb.UserPreferences.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Object findById(@PathVariable(value = "id") String id){
        return reviewsService.findById(id).orElseThrow(() -> new ReviewNotFoundByIdException(id));
    }

    @GetMapping("/reviews/user/{id}")
    public Object findByUserId(@PathVariable(value = "id") String id){
        return reviewsService.findByUserId(id).orElseThrow(() -> new ReviewNotFoundByUserIdException(id));
    }

    @GetMapping("/reviews/movie/{id}")
    public Object findByMovieId(@PathVariable(value = "id") String id){
        return reviewsService.findByMovieId(id).orElseThrow(() -> new ReviewNotFoundByMovieIdException(id));
    }

    @DeleteMapping("/reviews/{id}")
    public void delete(@PathVariable(value = "id") String id){
        reviewsService.deleteById(id);
    }
}

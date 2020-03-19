package com.moviedb.UserPreferences.controllers;

import com.moviedb.UserPreferences.models.Comment;
import com.moviedb.UserPreferences.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class CommentsController {
    @Autowired
    CommentsRepository commentsRepository;

    @GetMapping("/")
    public String index(){
        return ("comments, comments/{userId}, comments/{movieId}, watchlists, watchlists/{userId}, watchlists/{movieId}, watchlists/{userId}?public=true...");
    }

    @GetMapping("/comments")
    public List<Comment> find(){
        return commentsRepository.findAll();
    }

    @GetMapping("/comments/{id}")
    public Object findById(@PathVariable(value = "id") String id, @RequestParam(required = false) String type){
        Integer ID = parseInt(id);

        if (type == null){
            return commentsRepository.findById(ID);
        }
        else if (type.toLowerCase().equals("movie")){
            return commentsRepository.findByMovieId(ID);
        }
        else if (type.toLowerCase().equals("user")){
            return commentsRepository.findByUserId(ID);
        }

        return null;
    }
}

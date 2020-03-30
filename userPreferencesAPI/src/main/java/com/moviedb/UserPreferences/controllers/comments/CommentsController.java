package com.moviedb.UserPreferences.controllers.comments;

import com.moviedb.UserPreferences.controllers.comments.exceptions.CommentNotFoundByIdException;
import com.moviedb.UserPreferences.controllers.comments.exceptions.CommentNotFoundByMovieIdException;
import com.moviedb.UserPreferences.controllers.comments.exceptions.CommentNotFoundByUserIdException;
import com.moviedb.UserPreferences.models.Comment;
import com.moviedb.UserPreferences.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class CommentsController {
    @Autowired
    CommentsService commentsService;

    @GetMapping("/")
    public String index(){
        return ("comments, comments/{userId}, comments/{movieId}, watchlists, watchlists/{userId}, watchlists/{movieId}, watchlists/{userId}?public=true...");
    }

    @GetMapping("/comments")
    public List<Comment> find(){
        return commentsService.findAll();
    }

    @GetMapping("/comments/{id}")
    public Object findById(@PathVariable(value = "id") String id){
        return commentsService.findById(id).orElseThrow(() -> new CommentNotFoundByIdException(id));
    }

    @GetMapping("/comments/user/{id}")
    public Object findByUserId(@PathVariable(value = "id") String id){
        return commentsService.findByUserId(id).orElseThrow(() -> new CommentNotFoundByUserIdException(id));
    }

    @GetMapping("/comments/movie/{id}")
    public Object findByMovieId(@PathVariable(value = "id") String id){
        return commentsService.findByMovieId(id).orElseThrow(() -> new CommentNotFoundByMovieIdException(id));
    }


    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable(value = "id") String id){
        commentsService.deleteById(id);
    }
}

package com.moviedb.UserPreferences.controllers.comments;

import com.moviedb.UserPreferences.controllers.comments.exceptions.CommentNotFoundByIdException;
import com.moviedb.UserPreferences.models.Comment;
import com.moviedb.UserPreferences.repositories.CommentsRepository;
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
    public Object findById(@PathVariable(value = "id") String id, @RequestParam(required = false) String type){
        Object result = commentsService.findById(id,type);
        if(result==null)
            throw new CommentNotFoundByIdException(id, type);
        else
            return result;
    }
}

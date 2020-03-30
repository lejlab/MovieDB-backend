package com.moviedb.UserPreferences.services;

import com.moviedb.UserPreferences.models.Comment;
import com.moviedb.UserPreferences.reviews.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
public class CommentsService {
    @Autowired
    CommentsRepository commentsRepository;

    public List<Comment> findAll(){
        return commentsRepository.findAll();
    }

    public Optional<Comment> findById(String id){
        Integer ID = parseInt(id);
        return commentsRepository.findById(ID);
    }

    public Optional<List<Comment>> findByMovieId(String id){
        Integer ID = parseInt(id);
        return commentsRepository.findByMovieId(ID);
    }

    public Optional<List<Comment>> findByUserId(String id){
        Integer ID = parseInt(id);
        return commentsRepository.findByUserId(ID);
    }

    public void deleteById(String id) {
        Integer ID = parseInt(id);
        commentsRepository.deleteById(ID);
    }

}

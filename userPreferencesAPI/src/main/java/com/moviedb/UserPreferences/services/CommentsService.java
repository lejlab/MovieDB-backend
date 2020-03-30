package com.moviedb.UserPreferences.services;

import com.moviedb.UserPreferences.models.Comment;
import com.moviedb.UserPreferences.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class CommentsService {
    @Autowired
    CommentsRepository commentsRepository;

    public List<Comment> findAll(){
        return commentsRepository.findAll();
    }

    public Object findById(String id, String type){
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

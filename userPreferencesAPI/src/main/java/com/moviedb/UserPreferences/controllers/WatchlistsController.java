package com.moviedb.UserPreferences.controllers;

import com.moviedb.UserPreferences.models.Watchlist;
import com.moviedb.UserPreferences.repositories.WatchlistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class WatchlistsController {
    @Autowired
    WatchlistsRepository watchlistsRepository;

    @GetMapping("/watchlists")
    public List<Watchlist> find(@RequestParam(required = false) String isPublic){
        if (isPublic == null) return watchlistsRepository.findAll();
        else {
            if (isPublic.toLowerCase().equals("true")) return watchlistsRepository.findAllPublic();
            return null;
        }
    }

    @GetMapping("/watchlists/{id}")
    public Object findById(@PathVariable(value = "id") String id, @RequestParam(required = false) String type, @RequestParam(required = false) String isPublic){
        Integer ID = parseInt(id);

        if (type == null){
            return watchlistsRepository.findById(ID);
        }
        else if (type.toLowerCase().equals("movie")){
            return watchlistsRepository.findByMovieId(ID);
        }
        else if (type.equals("user")){
            if (isPublic.toLowerCase().equals("true")) return watchlistsRepository.findByUserIdPublic(ID);
            else if (isPublic.toLowerCase().equals("false")) return watchlistsRepository.findByUserIdPrivate(ID);
            return watchlistsRepository.findByUserId(ID);
        }

        return null;
    }
}

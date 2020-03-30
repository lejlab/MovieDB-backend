package com.moviedb.UserPreferences.controllers.watchlists;

import com.moviedb.UserPreferences.controllers.watchlists.exceptions.WatchlistNotFoundByIdException;
import com.moviedb.UserPreferences.models.Watchlist;
import com.moviedb.UserPreferences.repositories.WatchlistsRepository;
import com.moviedb.UserPreferences.services.WatchlistsService;
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
    WatchlistsService watchlistsService;

    @GetMapping("/watchlists")
    public List<Watchlist> find(@RequestParam(required = false) String isPublic){
       return watchlistsService.findAll(isPublic);
    }

    @GetMapping("/watchlists/{id}")
    public Object findById(@PathVariable(value = "id") String id, @RequestParam(required = false) String type, @RequestParam(required = false) String isPublic){
        Object result =  watchlistsService.findById(id, type, isPublic);
        if(result == null)
            throw new WatchlistNotFoundByIdException(id, type);
        else
            return result;
    }
}

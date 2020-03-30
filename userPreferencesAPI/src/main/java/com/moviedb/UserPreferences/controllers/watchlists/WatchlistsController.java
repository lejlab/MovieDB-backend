package com.moviedb.UserPreferences.controllers.watchlists;

import com.moviedb.UserPreferences.controllers.watchlists.exceptions.WatchlistNotFoundByIdException;
import com.moviedb.UserPreferences.controllers.watchlists.exceptions.WatchlistNotFoundByMovieIdException;
import com.moviedb.UserPreferences.controllers.watchlists.exceptions.WatchlistNotFoundByUserIdException;
import com.moviedb.UserPreferences.models.Watchlist;
import com.moviedb.UserPreferences.services.WatchlistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Object findById(@PathVariable(value = "id") String id){
        return watchlistsService.findById(id).orElseThrow(() -> new WatchlistNotFoundByIdException(id));
    }

    @GetMapping("/watchlists/user/{id}")
    public Object findByUserId(@PathVariable(value = "id") String id, @RequestParam(required = false) String isPublic){
        return watchlistsService.findByUserId(id, isPublic).orElseThrow(() -> new WatchlistNotFoundByUserIdException(id));
    }

    @GetMapping("/watchlists/movie/{id}")
    public Object findByMovieId(@PathVariable(value = "id") String id){
        return watchlistsService.findByMovieId(id).orElseThrow(() -> new WatchlistNotFoundByMovieIdException(id));
    }

    @DeleteMapping("/watchlists/{id}")
    public void delete(@PathVariable(value = "id") String id){
        watchlistsService.deleteById(id);
    }
}

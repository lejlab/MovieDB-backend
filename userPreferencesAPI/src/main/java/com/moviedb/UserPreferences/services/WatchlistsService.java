package com.moviedb.UserPreferences.services;

import com.moviedb.UserPreferences.models.Watchlist;
import com.moviedb.UserPreferences.reviews.WatchlistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
public class WatchlistsService {

    @Autowired
    WatchlistsRepository watchlistsRepository;

    public List<Watchlist> findAll(String isPublic){
        if (isPublic == null) return watchlistsRepository.findAll();
        else {
            if (isPublic.toLowerCase().equals("true")) return watchlistsRepository.findAllPublic();
            return null;
        }
    }


    public Optional<Watchlist> findById(String id){
        Integer ID = parseInt(id);
        return watchlistsRepository.findById(ID);
    }

    public Optional<List<Watchlist>> findByMovieId(String id){
        Integer ID = parseInt(id);
        return watchlistsRepository.findByMovieId(ID);
    }

    public Optional<List<Watchlist>> findByUserId(String id, String isPublic){
        Integer ID = parseInt(id);

        if (isPublic.toLowerCase().equals("true")) return watchlistsRepository.findByUserIdPublic(ID);
        else if (isPublic.toLowerCase().equals("false")) return watchlistsRepository.findByUserIdPrivate(ID);
        return watchlistsRepository.findByUserId(ID);
    }

    public void deleteById(String id) {
        Integer ID = parseInt(id);
        watchlistsRepository.deleteById(ID);
    }

}

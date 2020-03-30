package com.moviedb.UserPreferences.services;

import com.moviedb.UserPreferences.models.Watchlist;
import com.moviedb.UserPreferences.repositories.WatchlistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Object findById(String id, String type, String isPublic){
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

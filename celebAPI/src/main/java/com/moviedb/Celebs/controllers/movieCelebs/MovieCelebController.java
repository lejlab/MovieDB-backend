package com.moviedb.Celebs.controllers.movieCelebs;

import com.moviedb.Celebs.controllers.celebJobs.exceptions.CelebJobsNotFoundException;
import com.moviedb.Celebs.controllers.movieCelebs.expceptions.MovieCelebsNotFoundException;
import com.moviedb.Celebs.models.CelebJobs;
import com.moviedb.Celebs.models.MovieCeleb;
import com.moviedb.Celebs.services.MovieCelebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.moviedb.Celebs.repositories.MovieCelebsRepository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class MovieCelebController {
    @Autowired
    private MovieCelebService movieCelebService;
    @Autowired
    MovieCelebsRepository movieCelebsRepository;

    @GetMapping("/moviecelebs")
    public List<MovieCeleb> getAll(){
        return movieCelebService.getAll();
    }

    @GetMapping("/moviecelebs/{id}")
    public MovieCeleb getOneById(@PathVariable(value = "id") Integer id) {
        return movieCelebService.getOneById(id).orElseThrow(() -> new MovieCelebsNotFoundException(id));
    }

    @GetMapping("/moviecelebs/list/{id}")
    public List<MovieCeleb> findAllById(@PathVariable(value = "id") String id, @RequestParam String type){
        Integer movieCelebId = parseInt(id);

        if (type.equals("movie")){
            return movieCelebService.getAllByMovieId(movieCelebId);
        }
        else if (type.equals("celeb")) {
            return movieCelebService.getAllByCelebId(movieCelebId);
        }
        else {
            return new ArrayList<MovieCeleb>();
        }
    }

    @PostMapping("/moviecelebs")
    public MovieCeleb addOne(@RequestBody MovieCeleb newMovieCeleb) {
        return movieCelebService.addOne(newMovieCeleb);
    }

    @PutMapping("/moviecelebs/{id}")
    public MovieCeleb editOne(@RequestBody MovieCeleb newData, @PathVariable("id") Integer id) {
        return movieCelebService.editOne(newData, id);
    }

    @DeleteMapping("/moviecelebs/{id}")
    public void removeOne(@PathVariable Integer id) {
        movieCelebService.removeOne(id);
    }
}

package controllers;

import models.Celeb;
import models.MovieCeleb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repositories.MovieCelebsRepository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class MovieCelebController {
    @Autowired
    MovieCelebsRepository movieCelebsRepository;

    @GetMapping("/moviecelebs")
    public List<MovieCeleb> find(){
        return movieCelebsRepository.findAll();
    }

    @GetMapping("/moviecelebs/{id}")
    public List<MovieCeleb> findByUserId(@PathVariable(value = "id") String id, @RequestParam String type) {
        Integer movieCelebId = parseInt(id);

        if (type.equals("celeb")) {
            return movieCelebsRepository.findByCelebId(movieCelebId);
        } else if (type.equals("movie")) {
            return movieCelebsRepository.findByMovieId(movieCelebId);
        } else {
            return new ArrayList<MovieCeleb>();
        }
    }
}

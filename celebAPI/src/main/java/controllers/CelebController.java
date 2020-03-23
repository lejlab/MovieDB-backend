package controllers;

import models.Celeb;
import models.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import repositories.CelebsRepository;

import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class CelebController {
    @Autowired
    CelebsRepository celebsRepository;

    @GetMapping("/")
    public String index(){
        return ("celebs, celebs/{name}, celebs/{date}, jobs, celebjobs, ceclebjobs/{id}, moviecelebs, moviecelebs{id}");
    }

    @GetMapping("/celebs")
    public List<Celeb> find() {
        return celebsRepository.findAll();
    }

    @GetMapping("/celebs/{name}")
    public List<Celeb> find(@PathVariable("name") String name) {
        return celebsRepository.findByName(name);
    }

    @GetMapping("/celebs/{date}")
    public List<Celeb> find(@PathVariable("name") Date date) {
        return celebsRepository.findByDateOfBirth(date);
    }

}

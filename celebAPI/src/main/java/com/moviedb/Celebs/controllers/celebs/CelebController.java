package com.moviedb.Celebs.controllers.celebs;

import com.moviedb.Celebs.controllers.celebs.exceptions.CelebNotFoundException;
import com.moviedb.Celebs.controllers.celebs.exceptions.CelebTypeNotFoundException;
import com.moviedb.Celebs.models.Celeb;
import com.moviedb.Celebs.models.CelebJobs;
import com.moviedb.Celebs.services.CelebsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.moviedb.Celebs.repositories.CelebsRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class CelebController {
    @Autowired
    private CelebsService celebsService;
    @Autowired
    CelebsRepository celebsRepository;

    @GetMapping("/celebs")
    public List<Celeb> getAll(){
        return celebsService.getAll();
    }

    @GetMapping("/celebs/{id}")
    public Celeb getOneById(@PathVariable(value = "id") Integer id) {
        return celebsService.getOneById(id).orElseThrow(() -> new CelebNotFoundException(id));
    }

    @GetMapping("/celebs/identification/{something}")
    public List<Celeb> getAllBySomething(@PathVariable(value = "something") String something, @RequestParam String type) throws ParseException {

        if (type.equals("name")) {
            return celebsService.getAllByName(something);
        }
        else if (type.equals("date")) {
            return celebsService.getAllByDateOfBirth(something);
        }
        else {
            throw new CelebTypeNotFoundException(type);
        }
    }

    @PostMapping("/celebs")
    public Celeb addNewOne(@RequestBody Celeb newCeleb) {
        return celebsService.addOne(newCeleb);
    }

    @PutMapping("/celebs/{id}")
    public Celeb editOne(@RequestBody Celeb newData, @PathVariable("id") Integer id) {
        return celebsService.editOne(newData, id);
    }

    @DeleteMapping("/celebs/{id}")
    public void deleteOne(@PathVariable Integer id) {
        celebsService.removeOne(id);
    }
}

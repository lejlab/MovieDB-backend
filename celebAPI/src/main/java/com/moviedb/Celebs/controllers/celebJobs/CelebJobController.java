package com.moviedb.Celebs.controllers.celebJobs;

import com.moviedb.Celebs.models.CelebJobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.moviedb.Celebs.repositories.CelebJobsRepository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class CelebJobController {
    @Autowired
    CelebJobsRepository celebJobsRepository;

    @GetMapping("/celebjobs")
    public List<CelebJobs> find() {
        return celebJobsRepository.findAll();
    }

    @GetMapping("/celebjobs/{id}")
    public List<CelebJobs> findByUserId(@PathVariable(value = "id") String id, @RequestParam String type){
        Integer celebJobId = parseInt(id);

        if (type.equals("celeb")){
            return celebJobsRepository.findByCelebId(celebJobId);
        }
        else if (type.equals("job")) {
            return celebJobsRepository.findByJobId(celebJobId);
        }
        else {
            return new ArrayList<CelebJobs>();
        }
    }
}

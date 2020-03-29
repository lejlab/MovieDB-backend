package com.moviedb.Celebs.controllers.jobs;

import com.moviedb.Celebs.controllers.jobs.exceptions.JobsNotFoundException;
import com.moviedb.Celebs.models.Job;
import com.moviedb.Celebs.services.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.moviedb.Celebs.repositories.JobsRepository;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class JobController {
    @Autowired
    private JobsService jobsService;
    @Autowired
    JobsRepository jobsRepository;

    @GetMapping("/jobs")
    public List<Job> getAll(){
        return jobsService.getAll();
    }

    @GetMapping("/jobs/{id}")
    public Job getOneById(@PathVariable(value = "id") Integer id) {
        return jobsService.getOneById(id).orElseThrow(() -> new JobsNotFoundException(id));
    }

    @PostMapping("/jobs")
    public Job addOne(@RequestBody Job newJob) {
        return jobsService.addOne(newJob);
    }

    @PutMapping("/jobs/{id}")
    public Job editOne(@RequestBody Job newData, @PathVariable("id") Integer id) {
        return jobsService.editOne(newData, id);
    }

    @DeleteMapping("/jobs/{id}")
    public void removeOne(@PathVariable Integer id) {
        jobsService.removeOne(id);
    }
}

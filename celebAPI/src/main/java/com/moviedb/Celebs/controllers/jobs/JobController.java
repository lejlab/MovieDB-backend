package com.moviedb.Celebs.controllers.jobs;

import com.moviedb.Celebs.models.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.moviedb.Celebs.repositories.JobsRepository;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class JobController {
    @Autowired
    JobsRepository jobsRepository;

    @GetMapping("/jobs")
    public List<Job> find() {
        return jobsRepository.findAll();
    }
}

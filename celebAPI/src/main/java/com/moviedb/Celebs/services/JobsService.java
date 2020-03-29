package com.moviedb.Celebs.services;

import com.moviedb.Celebs.models.Job;
import com.moviedb.Celebs.repositories.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobsService {
    @Autowired
    private JobsRepository jobsRepository;

    public List<Job> getAll() {
        return jobsRepository.findAll();
    }

    public Optional<Job> getOneById(Integer id) {
        return jobsRepository.findById(id);
    }

    public Job addOne(Job job) {
        return jobsRepository.save(job);
    }

    public Job editOne(Job newData, Integer id) {
        return jobsRepository.findById(id)
                .map(job -> {
                    job.setTitle(newData.getTitle());
                    job.setCelebs(newData.getCelebs());
                    return jobsRepository.save(job);
                }).orElseGet(() -> jobsRepository.save(newData));
    }

    public void removeOne(Integer id) {
        jobsRepository.deleteById(id);
    }




}

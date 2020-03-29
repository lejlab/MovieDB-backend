package com.moviedb.Celebs.services;

import com.moviedb.Celebs.models.CelebJobs;
import com.moviedb.Celebs.repositories.CelebJobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelebJobsService {
    @Autowired
    CelebJobsRepository celebJobsRepository;

    public List<CelebJobs> getAll() {
        return celebJobsRepository.findAll();
    }

    public Optional<CelebJobs> getOneById(Integer id) {
        return celebJobsRepository.findById(id);
    }

    public List<CelebJobs> getAllByJobId(Integer id) {
        return celebJobsRepository.findByJobId(id);
    }

    public List<CelebJobs> getAllByCelebId(Integer id) {
        return celebJobsRepository.findByCelebId(id);
    }

    public CelebJobs addOne(CelebJobs celebJob) {
        return celebJobsRepository.save(celebJob);
    }

    public CelebJobs editOne(CelebJobs newData, Integer id) {
        return celebJobsRepository.findById(id)
                .map(celebJob -> {
                    celebJob.setCeleb(newData.getCeleb());
                    celebJob.setJob(newData.getJob());
                    return celebJobsRepository.save(celebJob);
                }).orElseGet(() -> celebJobsRepository.save(newData));
    }

    public void removeOne(Integer id) {
        celebJobsRepository.deleteById(id);
    }
}

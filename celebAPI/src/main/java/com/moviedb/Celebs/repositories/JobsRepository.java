package com.moviedb.Celebs.repositories;

import com.moviedb.Celebs.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Job, Integer> {

}
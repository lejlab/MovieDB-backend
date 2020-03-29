package com.moviedb.Celebs.services;

import com.moviedb.Celebs.models.Celeb;
import com.moviedb.Celebs.repositories.CelebsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CelebsService {
    @Autowired
    private CelebsRepository celebsRepository;

    public List<Celeb> getAll() {
        return celebsRepository.findAll();
    }

    public Optional<Celeb> getOneById(Integer id) {
        return celebsRepository.findById(id);
    }

    public List<Celeb> getAllByName(String name) {
        return celebsRepository.findByName(name);
    }

    public List<Celeb> getAllByDateOfBirth(String date) {
        return celebsRepository.findByDateOfBirth(date);
    }

    public Celeb addOne(Celeb celeb) {
        return celebsRepository.save(celeb);
    }

    public Celeb editOne(Celeb newData, Integer id) {
        return celebsRepository.findById(id)
                .map(celeb -> {
                    celeb.setFirstName(newData.getFirstName());
                    celeb.setLastName(newData.getLastName());
                    celeb.setDateOfBirth(newData.getDateOfBirth());
                    celeb.setJobs(newData.getJobs());
                    celeb.setMovies(newData.getMovies());
                    return celebsRepository.save(celeb);
                }).orElseGet(() -> celebsRepository.save(newData));
    }

    public void removeOne(Integer id) {
        celebsRepository.deleteById(id);
    }
}

package com.moviedb.Users.services;

import com.moviedb.Users.models.Subscribe;
import com.moviedb.Users.repositories.SubscriptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionsService {
    @Autowired
    private SubscriptionsRepository subscriptionsRepository;

    public List<Subscribe> getAllSubscriptions() {
        return subscriptionsRepository.findAll();
    }

    public Subscribe addNewSubscription(Subscribe subscribe) {
        return subscriptionsRepository.save(subscribe);
    }

    public Optional<Subscribe> getOneById(Integer id) {
        return subscriptionsRepository.findById(id);
    }

    public void removeOne(Integer id) {
        subscriptionsRepository.deleteById(id);
    }

    public Optional<List<Subscribe>> getOneByOwnerUserId(Integer id) {
        return subscriptionsRepository.findByOwnerUserId(id);
    }

    public Optional<List<Subscribe>> getOneBySubscribedUserId(Integer id) {
        return subscriptionsRepository.findBySubscribedUserId(id);
    }
}

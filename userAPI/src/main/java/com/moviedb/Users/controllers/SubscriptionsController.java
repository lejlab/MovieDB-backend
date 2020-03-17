package com.moviedb.Users.controllers;


import com.moviedb.Users.models.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.moviedb.Users.repositories.SubscriptionsRepository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class SubscriptionsController {
    @Autowired
    SubscriptionsRepository subscriptionsRepository;

    @GetMapping("/subscriptions")
    public List<Subscribe> find(){
        return subscriptionsRepository.findAll();
    }

    @GetMapping("/subscriptions/{id}")
    public List<Subscribe> findByUserId(@PathVariable(value = "id") String id, @RequestParam String type){
        Integer userId = parseInt(id);

        if (type.equals("subscribed")){
            return subscriptionsRepository.findBySubscribedUserId(userId);
        }
        else if (type.equals("owner")) {
            return subscriptionsRepository.findByOwnerUserId(userId);
        }
        return new ArrayList<Subscribe>();
    }
}

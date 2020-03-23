package com.moviedb.Users.controllers.subscriptions;


import com.moviedb.Users.controllers.subscriptions.exceptions.SubscriptionNotFoundByOwnerIdException;
import com.moviedb.Users.controllers.subscriptions.exceptions.SubscriptionNotFoundBySubscribedIdException;
import com.moviedb.Users.controllers.subscriptions.exceptions.SubscriptionNotFoundException;
import com.moviedb.Users.models.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/subscriptions")
    public Subscribe newSubscription(@RequestBody Subscribe newSubscribe) {
        return subscriptionsRepository.save(newSubscribe);
    }

    @GetMapping("/subscriptions/{id}")
    public Object findById(@PathVariable(value = "id") Integer id) {
        return subscriptionsRepository.findById(id).orElseThrow(() -> new SubscriptionNotFoundException(id));
    }

    @DeleteMapping("/subscriptions/{id}")
    public void deleteSubscribe(@PathVariable Integer id) {
        subscriptionsRepository.deleteById(id);
    }

    @GetMapping("/subscriptions/identification/{id}")
    public Object findByUserId(@PathVariable(value = "id") String id, @RequestParam String type){
        Integer userId = parseInt(id);

        if (type.equals("subscribed")){
            return subscriptionsRepository.findBySubscribedUserId(userId).orElseThrow(() -> new SubscriptionNotFoundBySubscribedIdException(userId));
        }
        else if (type.equals("owner")) {
            return subscriptionsRepository.findByOwnerUserId(userId).orElseThrow(() -> new SubscriptionNotFoundByOwnerIdException(userId));
        }
        return new ArrayList<Subscribe>();
    }
}

package com.moviedb.Users.controllers.subscriptions;


import com.moviedb.Users.controllers.subscriptions.exceptions.SubscriptionNotFoundByOwnerIdException;
import com.moviedb.Users.controllers.subscriptions.exceptions.SubscriptionNotFoundBySubscribedIdException;
import com.moviedb.Users.controllers.subscriptions.exceptions.SubscriptionNotFoundException;
import com.moviedb.Users.models.Subscribe;
import com.moviedb.Users.services.SubscriptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.moviedb.Users.repositories.SubscriptionsRepository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class SubscriptionsController {
    @Autowired
    private SubscriptionsService subscriptionsService;

    @Autowired
    SubscriptionsRepository subscriptionsRepository;

    @GetMapping("/subscriptions")
    public List<Subscribe> getAllSubscriptions(){
        return subscriptionsService.getAllSubscriptions();
    }

    @PostMapping("/subscriptions")
    public Subscribe newSubscription(@RequestBody Subscribe newSubscribe) {
        return subscriptionsService.addNewSubscription(newSubscribe);
    }

    @GetMapping("/subscriptions/{id}")
    public Object getOneById(@PathVariable(value = "id") Integer id) {
        return subscriptionsService.getOneById(id).orElseThrow(() -> new SubscriptionNotFoundException(id));
    }

    @DeleteMapping("/subscriptions/{id}")
    public void removeSubscription(@PathVariable Integer id) {
        subscriptionsService.removeOne(id);
    }

    @GetMapping("/subscriptions/identification/{id}")
    public Object findByUserId(@PathVariable(value = "id") Integer id, @RequestParam String type){
        if (type.equals("subscribed")){
            return subscriptionsService.getOneBySubscribedUserId(id).orElseThrow(() -> new SubscriptionNotFoundBySubscribedIdException(id));
        }
        else if (type.equals("owner")) {
            return subscriptionsService.getOneByOwnerUserId(id).orElseThrow(() -> new SubscriptionNotFoundByOwnerIdException(id));
        }
        return new ArrayList<Subscribe>();
    }
}

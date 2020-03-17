package com.moviedb.Users.controllers;

import com.moviedb.Users.models.Notification;
import com.moviedb.Users.repositories.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.moviedb.Users.models.User;
import com.moviedb.Users.repositories.UsersRepository;

import static java.lang.Integer.parseInt;

@RestController
public class NotificationsController {
    @Autowired
    NotificationsRepository notificationsRepository;

    @GetMapping("/notifications")
    public List<Notification> find(){
        return notificationsRepository.findAll();
    }

    @GetMapping("/notifications/{id}")
    public List<Notification> findByOwnerUserId(@PathVariable("id") String id){
        Integer userOwnerId = parseInt(id);
        return notificationsRepository.findByOwnerUserId(userOwnerId);
    }
}

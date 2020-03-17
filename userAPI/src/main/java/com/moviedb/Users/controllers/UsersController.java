package com.moviedb.Users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.moviedb.Users.models.User;
import com.moviedb.Users.repositories.UsersRepository;

@RestController
public class UsersController {
    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/")
    public String index(){
        return ("users, users/{username}, roles, roles/{type}, subscriptions, subscriptions/{ownerUserId}, subscriptions/{subscribedUserId}, notifications, notifications/{ownerUserId}");
    }

    @GetMapping("/users")
    public List<User> find(){
        return usersRepository.findAll();
    }

    @GetMapping("/users/{username}")
    public User findByUsername(@PathVariable("username") String username){
        return usersRepository.findByUsername(username);
    }
}

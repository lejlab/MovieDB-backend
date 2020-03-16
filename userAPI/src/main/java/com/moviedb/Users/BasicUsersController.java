package com.moviedb.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BasicUsersController {
    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/")
    public String index(){
        return ("Probaj /users ili /users/{username}");
    }

    @GetMapping("/users")
    public List<User> find(){
        return usersRepository.findAll();
    }

    @GetMapping("/user/{username}")
    public User findByUsername(@PathVariable("username") String username){
        return usersRepository.findByUsername(username);
    }
}

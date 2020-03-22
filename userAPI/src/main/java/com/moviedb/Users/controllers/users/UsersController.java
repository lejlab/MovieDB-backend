package com.moviedb.Users.controllers.users;

import com.moviedb.Users.controllers.users.exceptions.UserNotFoundByUsernameException;
import com.moviedb.Users.controllers.users.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.moviedb.Users.models.User;
import com.moviedb.Users.repositories.UsersRepository;

@RestController
public class UsersController {
    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/users")
    public List<User> find(){
        return usersRepository.findAll();
    }

    @PostMapping("/users")
    public User newUser(@RequestBody User newUser) {
        return usersRepository.save(newUser);
    }

    @PutMapping("/users/{id}")
    public User editUser(@RequestBody User newData, @PathVariable("id") Integer id) {
        return usersRepository.findById(id)
                .map(user -> {
                    user.setUsername(newData.getUsername());
                    user.setPassword(newData.getPassword());
                    user.setAvatarUrl(newData.getAvatarUrl());
                    user.setRole(newData.getRole());
                    user.setSubscribers(newData.getSubscribers());
                    user.setOwners(newData.getOwners());
                    user.setNotifications(newData.getNotifications());
                    System.out.println(user.toString());
                    return usersRepository.save(user);
                }).orElseGet(() -> usersRepository.save(newData));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        usersRepository.deleteById(id);
    }

    @GetMapping("/users/{id}")
    public Object findOneById(@PathVariable("id") Integer id) {
        return usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/users/identification/{username}")
    public Object findOneByUsername(@PathVariable("username") String username){
        return usersRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundByUsernameException(username));
    }
}

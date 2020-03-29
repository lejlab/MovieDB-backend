package com.moviedb.Users.controllers.users;

import com.moviedb.Users.controllers.users.exceptions.UserNotFoundByUsernameException;
import com.moviedb.Users.controllers.users.exceptions.UserNotFoundException;
import com.moviedb.Users.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.moviedb.Users.models.User;
import com.moviedb.Users.repositories.UsersRepository;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<User> getAll(){
        return usersService.getAllUsers();
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User newUser) {
        return usersService.addNewUser(newUser);
    }

    @PutMapping("/users/{id}")
    public User editOne(@RequestBody User user, @PathVariable("id") Integer id) {
        return usersService.editOne(user, id);
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable Integer id) {
        usersService.removeOne(id);
    }

    @GetMapping("/users/{id}")
    public Object getOneById(@PathVariable("id") Integer id) {
        return usersService.getOneById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/users/identification/{username}")
    public Object getOneByUsername(@PathVariable("username") String username){
        return usersService.getOneByUsername(username).orElseThrow(() -> new UserNotFoundByUsernameException(username));
    }
}

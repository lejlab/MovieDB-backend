package com.moviedb.Users.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.moviedb.Users.models.Role;
import com.moviedb.Users.repositories.RolesRepository;

import java.util.List;

@RestController
public class RolesController {
    @Autowired
    RolesRepository rolesRepository;

    @GetMapping("/roles")
    public List<Role> find(){
        return rolesRepository.findAll();
    }

    @GetMapping("/roles/{type}")
    public Role findByUsername(@PathVariable("type") String type){
        return rolesRepository.findByType(type);
    }
}

package com.moviedb.Users.controllers.roles;


import com.moviedb.Users.controllers.roles.exceptions.RoleNotFoundByTypeException;
import com.moviedb.Users.controllers.roles.exceptions.RoleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/roles")
    public Role newRole(@RequestBody Role newRole) {
        return rolesRepository.save(newRole);
    }

    @PutMapping("/roles/{id}")
    public Role editUser(@RequestBody Role newData, @PathVariable("id") Integer id) {
        return rolesRepository.findById(id)
                .map(role -> {
                    role.setType(newData.getType());
                    role.setUsers(newData.getUsers());
                    return rolesRepository.save(role);
                }).orElseGet(() -> rolesRepository.save(newData));
    }

    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable Integer id) {
        rolesRepository.deleteById(id);
    }

    @GetMapping("/roles/{id}")
    public Object findById(@PathVariable Integer id){
        return rolesRepository.findById(id).orElseThrow(() -> new RoleNotFoundException(id));
    }


    @GetMapping("/roles/identification/{type}")
    public Object findByUsername(@PathVariable("type") String type){
        return rolesRepository.findByType(type).orElseThrow(() -> new RoleNotFoundByTypeException(type));
    }
}

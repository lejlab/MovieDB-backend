package com.moviedb.Users.controllers.roles;


import com.moviedb.Users.controllers.roles.exceptions.RoleNotFoundByTypeException;
import com.moviedb.Users.controllers.roles.exceptions.RoleNotFoundException;
import com.moviedb.Users.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.moviedb.Users.models.Role;
import com.moviedb.Users.repositories.RolesRepository;

import java.util.List;

@RestController
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @GetMapping("/roles")
    public List<Role> getAll(){
        return rolesService.getAllRoles();
    }

    @PostMapping("/roles")
    public Role addNewRole(@RequestBody Role newRole) {
        return rolesService.addNewRole(newRole);
    }

    @PutMapping("/roles/{id}")
    public Role editUser(@RequestBody Role newData, @PathVariable("id") Integer id) {
        return rolesService.editOne(newData, id);
    }

    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable Integer id) {
        rolesService.removeOne(id);
    }

    @GetMapping("/roles/{id}")
    public Object getOneById(@PathVariable Integer id){
        return rolesService.getOneById(id).orElseThrow(() -> new RoleNotFoundException(id));
    }


    @GetMapping("/roles/identification/{type}")
    public Object getOneByType(@PathVariable("type") String type){
        return rolesService.getOneByType(type).orElseThrow(() -> new RoleNotFoundByTypeException(type));
    }
}

package com.moviedb.Users.services;

import com.moviedb.Users.models.Role;
import com.moviedb.Users.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    public List<Role> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Role addNewRole(Role role) {
        return rolesRepository.save(role);
    }

    public Optional<Role> getOneById(Integer id) {
        return rolesRepository.findById(id);
    }

    public Optional<Role> getOneByType(String type) {
        return rolesRepository.findByType(type);
    }

    public Role editOne(Role newData, Integer id) {
        return rolesRepository.findById(id)
                .map(role -> {
                    role.setType(newData.getType());
                    role.setUsers(newData.getUsers());
                    return rolesRepository.save(role);
                }).orElseGet(() -> rolesRepository.save(newData));
    }

    public void removeOne(Integer id) {
        rolesRepository.deleteById(id);
    }



}

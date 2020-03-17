package com.moviedb.Users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.moviedb.Users.models.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {
    Role findByType(String type);
}


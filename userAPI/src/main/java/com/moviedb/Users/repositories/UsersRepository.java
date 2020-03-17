package com.moviedb.Users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.moviedb.Users.models.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
   User findByUsername(String username);
}

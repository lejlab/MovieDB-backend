package com.moviedb.Users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.moviedb.Users.models.Subscribe;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionsRepository extends JpaRepository<Subscribe, Integer> {
    @Query(value = "SELECT s from Subscribe s WHERE owner_user_id = :id")
    Optional<List<Subscribe>> findByOwnerUserId(@Param("id") Integer id);
    @Query(value =  "SELECT s from Subscribe s WHERE subscribed_user_id = :id")
    Optional<List<Subscribe>> findBySubscribedUserId(@Param("id") Integer id);
}


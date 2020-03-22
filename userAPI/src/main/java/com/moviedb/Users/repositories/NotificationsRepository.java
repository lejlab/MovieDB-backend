package com.moviedb.Users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.moviedb.Users.models.Notification;
import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationsRepository extends JpaRepository<Notification, Integer> {
    @Query(value = "SELECT n from Notification n WHERE owner_user_id = :id")
    Optional<List<Notification>> findByOwnerUserId(@Param("id") Integer id);
}
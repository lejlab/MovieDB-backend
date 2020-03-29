package com.moviedb.Celebs.repositories;

import com.moviedb.Celebs.models.Celeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CelebsRepository extends JpaRepository<Celeb, Integer> {
    @Query(value = "SELECT c from Celeb c WHERE first_name = :name OR last_name = :name")
    List<Celeb> findByName(@Param("name") String name);
    @Query(value = "SELECT c from Celeb c WHERE date_of_birth = :dateOfBirth")
    List<Celeb> findByDateOfBirth(@Param("dateOfBirth") String dateOfBirth);
}
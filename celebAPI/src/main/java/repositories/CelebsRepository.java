package repositories;

import models.Celeb;
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
    @Query(value = "SELECT c from Celeb c WHERE dateOfBirth = :dateOfBirth")
    List<Celeb> findByDateOfBirth(@Param("dateOfBirth") Date dateOfBirth);
}

package repositories;

import models.Celeb;
import models.CelebJobs;
import models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CelebJobsRepository extends JpaRepository<CelebJobs, Integer> {
    @Query(value = "SELECT cj from CelebJobs cj WHERE celeb_id = :id")
    List<CelebJobs> findByCelebId(@Param("id") Integer id);
    @Query(value = "SELECT cj from CelebJobs cj WHERE job_id = :id")
    List<CelebJobs> findByJobId(@Param("id") Integer id);
}

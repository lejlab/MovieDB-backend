package repositories;

import models.CelebJobs;
import models.MovieCeleb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieCelebsRepository extends JpaRepository<MovieCeleb, Integer> {
    @Query(value = "SELECT mc from MovieCeleb mc WHERE celeb_id = :id")
    List<MovieCeleb> findByCelebId(@Param("id") Integer id);
    @Query(value = "SELECT mc from MovieCeleb mc WHERE movie_id = :id")
    List<MovieCeleb> findByMovieId(@Param("id") Integer id);
}

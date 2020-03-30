package com.moviedb.UserPreferences.reviews;

import com.moviedb.UserPreferences.models.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WatchlistsRepository extends JpaRepository<Watchlist, Integer> {
    @Query(value = "SELECT s from Watchlist s WHERE user_id = :id")
    Optional<List<Watchlist>> findByUserId(@Param("id") Integer userId);
    @Query(value = "SELECT s from Watchlist s WHERE movie_id = :id")
    Optional<List<Watchlist>> findByMovieId(@Param("id") Integer movieId);
    @Query(value = "SELECT w from Watchlist w WHERE user_id = :id AND is_public = 0")
    Optional<List<Watchlist>> findByUserIdPrivate(@Param("id") Integer id);
    @Query(value = "SELECT w from Watchlist w WHERE user_id = :id AND is_public = 1")
    Optional<List<Watchlist>> findByUserIdPublic(@Param("id") Integer id);
    @Query(value = "SELECT w from Watchlist w WHERE is_public = 1")
    List<Watchlist> findAllPublic();
}

package com.moviedb.UserPreferences.repositories;

import com.moviedb.UserPreferences.models.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistsRepository extends JpaRepository<Watchlist, Integer> {
    List<Watchlist> findByUserId(Integer userId);
    List<Watchlist> findByMovieId(Integer movieId);
    @Query(value = "SELECT w from Watchlist w WHERE user_id = :id AND is_public = 0")
    List<Watchlist> findByUserIdPrivate(@Param("id") Integer id);
    @Query(value = "SELECT w from Watchlist w WHERE user_id = :id AND is_public = 1")
    List<Watchlist> findByUserIdPublic(@Param("id") Integer id);
    @Query(value = "SELECT w from Watchlist w WHERE is_public = 1")
    List<Watchlist> findAllPublic();
}

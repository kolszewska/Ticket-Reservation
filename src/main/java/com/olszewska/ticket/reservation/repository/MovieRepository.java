package com.olszewska.ticket.reservation.repository;

import com.olszewska.ticket.reservation.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT m FROM Movie m WHERE m.id = ?1")
    Movie findById(int id);

    @Query("SELECT m FROM Movie m")
    List<Movie> findAllMovies();
}

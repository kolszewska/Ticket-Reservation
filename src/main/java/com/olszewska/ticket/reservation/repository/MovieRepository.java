package com.olszewska.ticket.reservation.repository;

import com.olszewska.ticket.reservation.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findById(int id);
}

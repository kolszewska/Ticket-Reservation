package com.olszewska.ticket.reservation.service;

import com.olszewska.ticket.reservation.model.Movie;

import java.util.List;

public interface MovieService {
    Movie findById(int id);
    List<Movie> findAllMovies();
}
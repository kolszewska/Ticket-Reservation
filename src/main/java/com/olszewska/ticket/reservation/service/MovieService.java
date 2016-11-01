package com.olszewska.ticket.reservation.service;

import com.olszewska.ticket.reservation.model.Movie;

public interface MovieService {
    Movie findById(int id);
}
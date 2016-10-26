package com.olszewska.ticket.reservation.service;

import com.olszewska.ticket.reservation.model.Show;

import java.util.List;

public interface ShowService {

    Show findById(int id);

    List<Show> findAllShows();

    void deleteShowById(int id);

}
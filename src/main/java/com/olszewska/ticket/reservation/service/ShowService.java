package com.olszewska.ticket.reservation.service;

import com.olszewska.ticket.reservation.model.Show;

import java.sql.Timestamp;
import java.util.List;

public interface ShowService {

    Show findById(int id);

    List<Show> findAllShows();

    //List<Show> findByDate(Timestamp date);

    void deleteShowById(int id);

}
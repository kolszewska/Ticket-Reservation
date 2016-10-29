package com.olszewska.ticket.reservation.service;

import com.olszewska.ticket.reservation.model.Reservation;
import com.olszewska.ticket.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RepositoryServiceImpl {

    @Qualifier("reservationRepository")
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation findById(int id) {
        return reservationRepository.findById(id);
    }
}

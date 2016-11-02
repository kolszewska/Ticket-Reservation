package com.olszewska.ticket.reservation.service;

import com.olszewska.ticket.reservation.model.Reservation;

public interface ReservationService {
    Reservation findById(int id);
    Reservation findByVerificationKey(String verificationKey);
}

package com.olszewska.ticket.reservation.repository;

import com.olszewska.ticket.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository("reservationRepository")
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation findById( int id);
    Reservation findByVerificationKey(String verificationKey);
}

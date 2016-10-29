package com.olszewska.ticket.reservation.repository;


import com.olszewska.ticket.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("reservationRepository")
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query("SELECT r FROM Reservation r WHERE r.id = ?1")
    Reservation findById(int id);
}

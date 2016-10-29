package com.olszewska.ticket.reservation.service;


import org.springframework.stereotype.Repository;

public interface ReservationService {
    Repository findByIdx(int id);
}

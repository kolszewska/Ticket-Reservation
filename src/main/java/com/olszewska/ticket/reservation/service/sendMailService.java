package com.olszewska.ticket.reservation.service;

import com.olszewska.ticket.reservation.model.Reservation;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
    public void getReservation(Reservation r) {
        System.out.print(r.getFirstName());
    }
}

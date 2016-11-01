package com.olszewska.ticket.reservation.service.Implementation;

import com.olszewska.ticket.reservation.model.Reservation;
import com.olszewska.ticket.reservation.repository.ReservationRepository;
import com.olszewska.ticket.reservation.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("reservationService")
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Qualifier("reservationRepository")
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation findById(int id) {
        return reservationRepository.findById(id);
    }
}

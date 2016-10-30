package com.olszewska.ticket.reservation.service;

import com.olszewska.ticket.reservation.model.Screening;
import java.util.List;

public interface ScreeningService {
    List<Screening> findAllScreenings();
    Screening findById(int id);
}

package com.olszewska.ticket.reservation.repository;

import com.olszewska.ticket.reservation.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository("screeningRepository")
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
    Screening findById(int id);
}

package com.olszewska.ticket.reservation.repository;

import com.olszewska.ticket.reservation.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("screeningRepository")
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
    @Query("SELECT s FROM Screening s order by s.time")
    List<Screening> findAllScreenings();

    Screening findById(@Param("id") int id);
}

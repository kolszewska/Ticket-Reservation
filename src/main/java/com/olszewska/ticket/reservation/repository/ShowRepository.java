package com.olszewska.ticket.reservation.repository;

import com.olszewska.ticket.reservation.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("showRepository")
public interface ShowRepository extends JpaRepository<Show, Integer> {
    @Query("SELECT s FROM Show s WHERE s.id = ?1")
    Show findById(@Param("id") int id);

    @Query("SELECT s FROM Show s")
    List<Show> findAllShows();

    void deleteShowById(@Param("id") int id);
}

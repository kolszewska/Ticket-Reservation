package com.olszewska.ticket.reservation.repository;

import com.olszewska.ticket.reservation.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository("showRepository")
public interface ShowRepository extends JpaRepository<Show, Integer> {
    @Query("SELECT s FROM Show s WHERE s.id = ?1")
    Show findById(int id);

    @Query("SELECT s FROM Show s")
    List<Show> findAllShows();

   // @Query("SELECT s FROM Show s WHERE s.date > ?1  ")
   // List<Show>findByDate(Timestamp date);

    void deleteShowById(int id);
}

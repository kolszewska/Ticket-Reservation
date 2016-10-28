package com.olszewska.ticket.reservation.service;

import com.olszewska.ticket.reservation.repository.ShowRepository;
import com.olszewska.ticket.reservation.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service("showService")
@Transactional
public class ShowServiceImpl implements ShowService {

    @Qualifier("showRepository")
    @Autowired
    private ShowRepository showRepository;

    public Show findById(int id) {
        return showRepository.findById(id);
    }

    public List<Show>findByDate(Timestamp date) {
        return showRepository.findByDate(date);
    }

    public List<Show> findAllShows() {
        return showRepository.findAllShows();
    }

    public void deleteShowById(int id) {
        showRepository.deleteShowById(id);
    }
}

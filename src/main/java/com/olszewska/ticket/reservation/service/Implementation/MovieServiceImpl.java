package com.olszewska.ticket.reservation.service.Implementation;

import com.olszewska.ticket.reservation.repository.MovieRepository;
import com.olszewska.ticket.reservation.model.Movie;
import com.olszewska.ticket.reservation.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("movieService")
@Transactional
public class MovieServiceImpl implements MovieService {

    @Qualifier("movieRepository")
    @Autowired
    private MovieRepository movieRepository;

    public Movie findById(int id) {
        return movieRepository.findById(id);
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAllMovies();
    }
}

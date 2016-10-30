package com.olszewska.ticket.reservation.controller;

import com.olszewska.ticket.reservation.model.Movie;
import com.olszewska.ticket.reservation.model.Reservation;
import com.olszewska.ticket.reservation.model.Screening;
import com.olszewska.ticket.reservation.repository.MovieRepository;
import com.olszewska.ticket.reservation.repository.ReservationRepository;
import com.olszewska.ticket.reservation.repository.ScreeningRepository;
import com.olszewska.ticket.reservation.service.MovieService;
import com.olszewska.ticket.reservation.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.util.List;

@Controller
public class AppController {

    @Qualifier("movieRepository")
    @Autowired
    MovieRepository movieRepository;

    @Qualifier("screeningRepository")
    @Autowired
    ScreeningRepository screeningRepository;

    @Qualifier("reservationRepository")
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    MovieService movieService;
    @Autowired
    ScreeningService screeningService;


    @RequestMapping(value = {"/", "/index"})
    public String startingView() {
        return "index";
    }

    @RequestMapping(value = "/moviesList")
    public String shopListPage(Model model) throws ParseException {
        List<Movie> moviesList = movieService.findAllMovies();
        List<Screening> screeningList = screeningService.findAllScreenings();
        model.addAttribute("screeningList",screeningList);
        model.addAttribute("moviesList", moviesList);
        return "moviesList";
    }

    @RequestMapping(value = "reservation/show/{showId}")
    public String reservation(@PathVariable(value = "showId") int showId, Model model) throws ParseException {
        Movie movie = movieService.findById(showId);
        model.addAttribute("movie", movie);
        return "reservation";
    }

    @RequestMapping(value = "/addReservation/{id}", method = RequestMethod.POST)
    public String addReservation(@PathVariable(value = "id") int id, Model model, Reservation reservation) {
        return "confirmReservation";
    }
}

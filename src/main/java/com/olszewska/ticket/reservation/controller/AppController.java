package com.olszewska.ticket.reservation.controller;

import com.olszewska.ticket.reservation.component.SendMail;
import com.olszewska.ticket.reservation.model.Movie;
import com.olszewska.ticket.reservation.model.Reservation;
import com.olszewska.ticket.reservation.model.Screening;
import com.olszewska.ticket.reservation.repository.MovieRepository;
import com.olszewska.ticket.reservation.repository.ReservationRepository;
import com.olszewska.ticket.reservation.repository.ScreeningRepository;
import com.olszewska.ticket.reservation.service.MovieService;
import com.olszewska.ticket.reservation.service.ScreeningService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.mail.MessagingException;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Controller
public class AppController {

    @Qualifier("movieRepository")
    @Autowired
    private MovieRepository movieRepository;

    @Qualifier("screeningRepository")
    @Autowired
    private ScreeningRepository screeningRepository;

    @Qualifier("reservationRepository")
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private SendMail sendMail;


    @RequestMapping(value = {"/", "/index"})
    public String startingView() {
        return "index";
    }

    @RequestMapping(value = "/moviesList")
    public String moviesList(Model model) throws ParseException {
        List<Movie> moviesList = movieRepository.findAll();
        List<Screening> screeningList = screeningRepository.findAll();
        model.addAttribute("screeningList", screeningList);
        model.addAttribute("moviesList", moviesList);
        return "moviesList";
    }

    @RequestMapping(value = "/reservation/screening/{screeningId}")
    public String reservation(@PathVariable(value = "screeningId") int screeningId, Model model) throws ParseException {
        Screening screening = screeningService.findById(screeningId);
        String movieTitle = screening.getMovie_id().getTitle();
        model.addAttribute("screening", screening);
        model.addAttribute("movieTitle", movieTitle);
        return "provideReservationData";
    }

    @RequestMapping(value = "/confirmData/{screeningId}", method = RequestMethod.POST)
    public String addNewReservation(@PathVariable(value = "screeningId") int screeningId, Model model, Reservation reservation) {
        Screening screening = screeningService.findById(screeningId);
        reservation.setScreening_id(screening);
        model.addAttribute("reservation", reservation);
        return "confirmData";
    }

    @RequestMapping(value = "/confirmReservation/{screeningId}", method = RequestMethod.POST)
    public String confirmReservationData(@PathVariable(value = "screeningId") int screeningId, Reservation reservation) throws MessagingException {
        Screening screening = screeningService.findById(screeningId);
        UUID newVerificationKey = UUID.randomUUID();
        reservation.setScreening_id(screening);
        reservation.setVerificationKey(newVerificationKey.toString());
        reservationRepository.save(reservation);
        sendMail.send(reservation);
        return "confirmReservation";
    }

    @RequestMapping(value = "/finishReservation/{verificationKey}")
    public String finishReservation(@PathVariable(value = "verificationKey") String verificationKey) {
        Reservation reservation = reservationRepository.findByVerificationKey(verificationKey);
        reservation.setConfirmed(true);
        reservationRepository.save(reservation);
        return "finishReservation";
    }

    @ExceptionHandler(Exception.class)
    public String handleError() {
        return "error";
    }
}

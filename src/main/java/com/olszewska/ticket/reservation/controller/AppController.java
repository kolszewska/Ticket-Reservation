package com.olszewska.ticket.reservation.controller;

import com.olszewska.ticket.reservation.model.Reservation;
import com.olszewska.ticket.reservation.model.Show;
import com.olszewska.ticket.reservation.repository.ShowRepository;
import com.olszewska.ticket.reservation.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
public class AppController {

    @Qualifier("showRepository")
    @Autowired
    ShowRepository showRepository;

    @Autowired
    ShowService showService;

    @RequestMapping(value = "/moviesList")
    public String shopListPage(Model model) throws ParseException {
        // java.util.Date date= new java.util.Date();
        List<Show> showList = showService.findAllShows();
        model.addAttribute("showList", showList);
        return "moviesList";
    }

    @RequestMapping(value = "reservation/show/{showId}")
    public String reservation(@PathVariable(value="showId") String showId, Model model) throws ParseException {
        int id  = Integer.parseInt(showId);
        Show show = showService.findById(id);
        model.addAttribute("show",show);
        return "reservation";
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public ModelAndView reservation() {
        return new ModelAndView("reservation","command", new Reservation());
    }

    @RequestMapping(value = "/addReservation/{showId}", method = RequestMethod.POST)
    public String addReservation(@PathVariable(value="showId") String showId, @ModelAttribute("SpringWeb")
            Reservation reservation, Model model) {

        int id  = Integer.parseInt(showId);
        Reservation newReservation = new Reservation();
        newReservation.setFirstName(reservation.getFirstName());
        newReservation.setLastName(reservation.getLastName());
        newReservation.setEmail(reservation.getEmail());
        newReservation.setTelephone(reservation.getTelephone());
        newReservation.setNumberOfTickets(reservation.getNumberOfTickets());
        newReservation.setShowId(id);

        model.addAttribute("firstName", newReservation.getFirstName());
        model.addAttribute("lastName", newReservation.getLastName());
        model.addAttribute("email", newReservation.getEmail());
        model.addAttribute("telephone", newReservation.getTelephone());
        model.addAttribute("showId", newReservation.getShowId());
        model.addAttribute("numberOfTickets", newReservation.getNumberOfTickets());
        return "confirmReservation";
    }
}

package com.olszewska.ticket.reservation.controller;

import com.olszewska.ticket.reservation.model.Show;
import com.olszewska.ticket.reservation.repository.ShowRepository;
import com.olszewska.ticket.reservation.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

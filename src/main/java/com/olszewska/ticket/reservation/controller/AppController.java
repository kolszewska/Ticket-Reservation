package com.olszewska.ticket.reservation.controller;

import com.olszewska.ticket.reservation.model.Show;
import com.olszewska.ticket.reservation.repository.ShowRepository;
import com.olszewska.ticket.reservation.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

@Controller
public class AppController {

    @Qualifier("showRepository")
    @Autowired
    ShowRepository showRepository;

    @Autowired
    ShowService showService;

    @RequestMapping(value = "/main")
    public String shopListPage(Model model) throws ParseException {
       // java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        List<Show> showList = showService.findAllShows();
        model.addAttribute("showList", showList);

        return "main";
    }
}

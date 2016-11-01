package com.olszewska.ticket.reservation.mail;

import com.olszewska.ticket.reservation.model.Reservation;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Component
public class SendMail {

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(Reservation reservation) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        helper = new MimeMessageHelper(message, true);
        helper.setSubject("Confirm reservation");

        Timestamp screeningTime = reservation.getScreening_id().getTime();
        String formattedDate = new SimpleDateFormat("YYYY-MM-dd HH:mm").format(screeningTime);

        helper.setTo(reservation.getEmail());
        String mailContent = "Dear " + reservation.getFirstName() + " " + reservation.getLastName() + "\n\r" +
                "Thank you for your reservation in our cinema" +
                "Movie: " + reservation.getScreening_id().getMovie_id().getName() + "\n\r" +
                "Date: " + formattedDate + "\n\r" +
                "Auditorium: " + reservation.getScreening_id().getAuditorium_id() + "\n\r" +
                "Please confirm your reservation clicking the link below" + "\n\r";

        helper.setText(mailContent, true);

        javaMailSender.send(message);
    }
}
package com.olszewska.ticket.reservation.component;

import com.olszewska.ticket.reservation.model.Reservation;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Component
@Slf4j
public class SendMail {

    @Autowired
    private JavaMailSender javaMailSender;

    private final static String SUBJECT = "Confirm your reservation";
    private final static String FROM = "kolszewskacinema@gmail.com";
    private final static String URL = "http://localhost:8080/finishReservation/";
    private Reservation reservation;

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    private MimeMessageHelper buildMessage(MimeMessageHelper message) throws MessagingException {
        message.setSubject(SUBJECT);
        message.setFrom(FROM);

        Timestamp screeningTime = reservation.getScreening_id().getTime();
        String formattedDate = new SimpleDateFormat("YYYY-MM-dd HH:mm").format(screeningTime);

        StringBuilder mailContent = new StringBuilder();
        mailContent.append("Dear ").append(reservation.getFirstName()).append(" ").append(reservation.getLastName()).append(",<br/>");
        mailContent.append("Your reservation was accepted and every detail can be found below: ").append("<br/><br/>");
        mailContent.append("Movie: ").append(reservation.getScreening_id().getMovie_id().getName()).append("<br/>");
        mailContent.append("Date: ").append(formattedDate).append("<br/>");
        mailContent.append("Auditorium: ").append(reservation.getScreening_id().getAuditorium_id());
        mailContent.append("<br/><br/>");
        mailContent.append("Please confirm your reservation clicking the link below: ").append("<br/><br/>");
        mailContent.append(URL).append(reservation.getVerificationKey());

        message.setText(mailContent.toString(), true);
        message.setTo(reservation.getEmail());

        return message;
    }

    public void send(Reservation reservation) {
        setReservation(reservation);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(message, true);
            log.info("Created new message successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
        try {
            buildMessage(mimeMessageHelper);
            log.info("Message was build successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
        javaMailSender.send(message);
        log.info("Message was send");
    }
}
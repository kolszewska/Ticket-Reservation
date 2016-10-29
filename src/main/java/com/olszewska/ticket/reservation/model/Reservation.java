package com.olszewska.ticket.reservation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show showId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "number_of_tickets")
    private int numberOfTickets;

    @Column(name = "confirmed")
    private boolean confirmed;
}

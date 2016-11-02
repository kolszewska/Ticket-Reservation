package com.olszewska.ticket.reservation.model;

import javax.persistence.*;
import java.io.Serializable;

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
    @JoinColumn(name = "screening_id")
    private Screening screening_id;

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

    @Column(name = "verification_key")
    private String verificationKey;
}

package com.olszewska.ticket.reservation.model;

import javax.persistence.*;
import java.sql.Timestamp;

@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "screening")
public class Screening {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "auditorium_id")
    private int auditorium_id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie_id;
}

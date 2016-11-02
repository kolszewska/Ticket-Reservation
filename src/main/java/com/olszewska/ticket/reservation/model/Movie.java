package com.olszewska.ticket.reservation.model;

import javax.persistence.*;
import java.io.Serializable;

@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;
}

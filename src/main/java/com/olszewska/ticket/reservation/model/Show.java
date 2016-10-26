package com.olszewska.ticket.reservation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "show")
public class Show implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "genre")
    private String genre;
}

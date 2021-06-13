package com.flightmanager.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "Flight")
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp date;

    @ManyToOne
    City startingCity;

    @ManyToOne
    City destinationCity;

    @ManyToOne
    Plane plane;

    public Flight() {
    }

    public Flight(Timestamp date, City startingCity, City destinationCity, Plane plane) {
        this.date = date;
        this.startingCity = startingCity;
        this.destinationCity = destinationCity;
        this.plane = plane;
    }
}

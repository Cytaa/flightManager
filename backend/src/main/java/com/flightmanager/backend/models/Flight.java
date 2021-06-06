package com.flightmanager.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "Flight")
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @JsonManagedReference
    @ManyToOne()
    City startingCity;

    @ManyToOne
    City destinationCity;

    @JsonBackReference
    @OneToOne
    Plane plane;

    public Flight() {
    }

    public Flight(Date date, City startingCity, City destinationCity, Plane plane) {
        this.date = date;
        this.startingCity = startingCity;
        this.destinationCity = destinationCity;
        this.plane = plane;
    }
}

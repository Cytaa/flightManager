package com.flightmanager.backend.models;

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

    private String companyName;

    private Date date;

    @ManyToOne()
    Destination destination;

    @OneToOne
    Plane plane;

    public Flight() {
    }
}

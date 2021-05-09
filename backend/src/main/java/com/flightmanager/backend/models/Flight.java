package com.flightmanager.backend.models;

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

    private String companyName;

    private Date date;

    @JsonManagedReference
    @ManyToOne()
    Destination destination;

    @OneToOne
    @JsonManagedReference
    Plane plane;

    public Flight() {
    }
}

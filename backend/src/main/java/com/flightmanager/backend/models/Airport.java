package com.flightmanager.backend.models;



import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    @ManyToOne(cascade = CascadeType.ALL)
    private Destination destinations;

    public Airport(String name, String country, Destination destinations) {
        this.name = name;
        this.country = country;
        this.destinations = destinations;
    }

    public Airport() {

    }
}


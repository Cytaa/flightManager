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

    private Long destinations;

    public Airport() {
    }

    public Airport(String name, String country, Long destinations) {
        this.name = name;
        this.country = country;
        this.destinations = destinations;
    }
}

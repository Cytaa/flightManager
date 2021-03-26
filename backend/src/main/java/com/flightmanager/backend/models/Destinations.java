package com.flightmanager.backend.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Destinations")
@Data
public class Destinations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    public Destinations(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Destinations() {
    }
}

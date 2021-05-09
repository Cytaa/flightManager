package com.flightmanager.backend.models;


import antlr.collections.impl.LList;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "Airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    @JsonManagedReference
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


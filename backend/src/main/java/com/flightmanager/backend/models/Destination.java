package com.flightmanager.backend.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Destinations")
@Data
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    public Destination(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Destination() {
    }

    @JsonManagedReference
    @OneToMany()
    private List<Flight> flights = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destinations")
    private Collection<Airport> airport;

    public Collection<Airport> getAirport() {
        return airport;
    }

    public void setAirport(Collection<Airport> airport) {
        this.airport = airport;
    }
}

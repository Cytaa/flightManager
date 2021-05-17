package com.flightmanager.backend.models;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @OneToMany()
    private List<Flight> flights = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destinations")
    private Collection<Airport> airport;

    public Collection<Airport> getAirport() {
        return airport;
    }

    public void setAirport(Collection<Airport> airport) {
        this.airport = airport;
    }
}

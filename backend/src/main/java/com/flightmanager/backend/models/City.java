package com.flightmanager.backend.models;

import lombok.Data;

import javax.persistence.*;

@Table(name = "City")
@Entity
@Data
public class City {

    @Id
    @GeneratedValue
    Long id;

    String name;

    String country;

    public City() {
    }

    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }
}

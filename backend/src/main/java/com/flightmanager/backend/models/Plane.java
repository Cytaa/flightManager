package com.flightmanager.backend.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Plane")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacturer;

    private String type;

    public Plane() {
    }

    public Plane(String manufacturer, String type){
        this.manufacturer = manufacturer;
        this.type = type;
    }
}

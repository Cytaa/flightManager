package com.flightmanager.backend.services;

import com.flightmanager.backend.models.Airport;
import com.flightmanager.backend.repositories.AirportRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    private final AirportRepo airportRepo;

    public AirportService(AirportRepo airportRepo) {
        this.airportRepo = airportRepo;
    }

    public List<Airport> getAllAirports(){
        return airportRepo.findAll();
    }

}

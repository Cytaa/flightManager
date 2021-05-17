package com.flightmanager.backend.services;

import com.flightmanager.backend.models.Flight;
import com.flightmanager.backend.repositories.FlightRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepo flightRepo;

    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }


    private List<Flight> getAllFlights(){
        return flightRepo.findAll();
    }
}

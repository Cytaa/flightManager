package com.flightmanager.backend.services;

import com.flightmanager.backend.models.Flight;
import com.flightmanager.backend.repositories.FlightRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private final FlightRepo flightRepo;

    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }


    public List<Flight> getAllFlights(){
        return flightRepo.findAll();
    }

    public List<Flight> getFlightsByDestination(String destination){
        return flightRepo.findAll().stream().filter(c -> c.getDestinationCity().getName().equals(destination)).collect(Collectors.toList());
    }

    public List<Flight> getFlightsByDeparture(String departure){
        return flightRepo.findAll().stream().filter(c -> c.getStartingCity().getName().equals(departure)).collect(Collectors.toList());
    }

    public List<Flight> getFlightsByDepartureAndDestination(String departure, String destination){
        return flightRepo.findAll().stream().filter(c -> c.getStartingCity().getName().equals(departure) && c.getDestinationCity().getName().equals(destination)).collect(Collectors.toList());
    }
}

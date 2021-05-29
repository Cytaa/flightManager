package com.flightmanager.backend.controllers;

import com.flightmanager.backend.models.Destination;
import com.flightmanager.backend.models.Plane;
import com.flightmanager.backend.services.AirportService;
import com.flightmanager.backend.services.DestinationService;
import com.flightmanager.backend.services.FlightService;
import com.flightmanager.backend.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController()
public class MainController {

    private final AirportService airportService;
    private final DestinationService destinationService;
    private final FlightService flightService;
    private final PlaneService planeService;

    @Autowired
    public MainController(AirportService airportService, DestinationService destinationService, FlightService flightService, PlaneService planeService) {
        this.airportService = airportService;
        this.destinationService = destinationService;
        this.flightService = flightService;
        this.planeService = planeService;
    }
    @GetMapping("/planes")
    public List<Plane> getAllPlanes(){
        return planeService.getAllPlanes();
    }

    @GetMapping("/destinstions")
    public List<Destination> getAllDestinations(){
        return destinationService.getAllDestinations();
    }

}

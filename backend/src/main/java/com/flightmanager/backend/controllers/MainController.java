package com.flightmanager.backend.controllers;

import com.flightmanager.backend.models.Flight;
import com.flightmanager.backend.models.Plane;
import com.flightmanager.backend.services.CityService;
import com.flightmanager.backend.services.FlightService;
import com.flightmanager.backend.services.PlaneService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController()
public class MainController {

    private final CityService cityService;
    private final FlightService flightService;
    private final PlaneService planeService;

    @Autowired
    public MainController(CityService cityService, FlightService flightService, PlaneService planeService) {
        this.cityService = cityService;
        this.flightService = flightService;
        this.planeService = planeService;
    }
    @GetMapping("/planes")
    public List<Plane> getAllPlanes(){
        return planeService.getAllPlanes();
    }

    @PostMapping(value = "/getFlightsByDestination")
    @ResponseBody
    public List<Flight> getFlightsByDestination(@RequestBody JSONObject jsonObject){
        return flightService.getFlightsByDestination(jsonObject.getAsString("destination"));
    }

    @PostMapping(value = "/getFlightsByDeparture")
    @ResponseBody
    public List<Flight> getFlightsByDeparture(@RequestBody JSONObject jsonObject){
        return flightService.getFlightsByDeparture(jsonObject.getAsString("destination"));
    }



}

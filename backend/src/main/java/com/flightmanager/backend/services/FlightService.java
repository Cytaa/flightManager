package com.flightmanager.backend.services;

import com.flightmanager.backend.models.Flight;
import com.flightmanager.backend.repositories.FlightRepo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return flightRepo.findAll().stream().filter(c -> c.getStartingCity().getName().equals(departure) && c.getDestinationCity().getName().equals(destination)).sorted(Comparator.comparing(Flight::getDate)).collect(Collectors.toList());
    }

    public List<List<Flight>> getFlightsWithTransfer(String departure, String destination) {
        List<Flight> allFlights = flightRepo.findAll();
        Stream<Flight> firstFlights = allFlights.stream().filter(f -> f.getStartingCity().getName().equals(departure));
        Supplier<Stream<Flight>> secondFlightsSupplier = () -> allFlights.stream().filter(f -> f.getDestinationCity().getName().equals(destination));

        return firstFlights.flatMap(f -> secondFlightsSupplier.get().map(s -> Arrays.asList(f, s)))
                .filter(fs -> fs.get(0).getDestinationCity() == fs.get(1).getStartingCity() && fs.get(0).getDate().before(fs.get(1).getDate()))
                .collect(Collectors.toList());
    }
}

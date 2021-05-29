package com.flightmanager.backend.repositories;

import com.flightmanager.backend.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepo extends JpaRepository<Flight,Long> {
   // @Query("select f from Flight f where f.destination = %?1")
    List<Flight> findByDestination(String destination);
}

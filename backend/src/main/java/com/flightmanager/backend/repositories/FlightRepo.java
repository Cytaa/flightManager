package com.flightmanager.backend.repositories;

import com.flightmanager.backend.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository<Flight,Long> {
}

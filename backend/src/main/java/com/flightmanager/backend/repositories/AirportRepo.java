package com.flightmanager.backend.repositories;

import com.flightmanager.backend.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport,Long>{
}

package com.flightmanager.backend.repositories;

import com.flightmanager.backend.models.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepo extends JpaRepository<Destination, Long>{
}

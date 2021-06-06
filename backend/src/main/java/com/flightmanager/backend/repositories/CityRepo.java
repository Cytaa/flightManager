package com.flightmanager.backend.repositories;

import com.flightmanager.backend.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Long> {
}

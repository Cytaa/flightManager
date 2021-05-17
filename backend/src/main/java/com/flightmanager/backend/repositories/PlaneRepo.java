package com.flightmanager.backend.repositories;
import com.flightmanager.backend.models.Plane;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepo extends JpaRepository<Plane,Long>{
}

package com.flightmanager.backend.services;


import com.flightmanager.backend.models.Plane;
import com.flightmanager.backend.repositories.PlaneRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {

    private final PlaneRepo planeRepo;


    public PlaneService(PlaneRepo planeRepo) {
        this.planeRepo = planeRepo;
    }

    public List<Plane> getAllPlanes(){
        return planeRepo.findAll();
    }
}

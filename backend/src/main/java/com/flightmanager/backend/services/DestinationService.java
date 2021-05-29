package com.flightmanager.backend.services;

import com.flightmanager.backend.models.Destination;
import com.flightmanager.backend.repositories.DestinationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    private final DestinationRepo destinationRepo;

    public DestinationService(DestinationRepo destinationRepo) {
        this.destinationRepo = destinationRepo;
    }

    public List<Destination> getAllDestinations(){
        return destinationRepo.findAll();
    }

}

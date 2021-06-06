package com.flightmanager.backend.services;

import com.flightmanager.backend.models.City;
import com.flightmanager.backend.repositories.CityRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
    private final CityRepo cityRepo;


    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public List<City> getAllCities(){
        return cityRepo.findAll();
    }

    public List<City> getAllCitiesByCountry(String country){
        return cityRepo.findAll().stream().filter( c -> c.getCountry().equals(country)).collect(Collectors.toList());
    }
}

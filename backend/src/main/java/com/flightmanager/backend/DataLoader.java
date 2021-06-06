package com.flightmanager.backend;

import com.flightmanager.backend.models.City;
import com.flightmanager.backend.models.Flight;
import com.flightmanager.backend.models.Plane;
import com.flightmanager.backend.repositories.CityRepo;
import com.flightmanager.backend.repositories.FlightRepo;
import com.flightmanager.backend.repositories.PlaneRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;

@Configuration
@Slf4j
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(CityRepo cityRepo, FlightRepo flightRepo, PlaneRepo planeRepo){
        return args -> {
            City city1 = new City("Warsaw", "Poland");
            City city2 = new City("Berlin", "Germany");

            cityRepo.save(city1);
            cityRepo.save(city2);

            Plane plane1 = new Plane("Manufacturer1", "Type1");

            planeRepo.save(plane1);

            Flight flight1 = new Flight(Date.valueOf("2021-06-06"), city1, city2, plane1);
            flightRepo.save(flight1);
        };
    }
}

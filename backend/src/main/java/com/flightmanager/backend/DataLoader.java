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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
@Slf4j
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(CityRepo cityRepo, FlightRepo flightRepo, PlaneRepo planeRepo){
        return args -> {
            List<City> allCities = new ArrayList<>();
            allCities.add(new City("Warsaw", "Poland"));
            allCities.add(new City("Berlin", "Germany"));
            allCities.add(new City("Beijing", "China"));
            allCities.add(new City("New Delhi", "India"));
            allCities.add(new City("Moscow", "Russia"));
            allCities.add(new City("Jakarta", "Indonesia"));
            allCities.add(new City("Seoul", "South Korea"));
            allCities.add(new City("Cairo", "Egypt"));
            allCities.add(new City("Mexico City", "Mexico"));
            allCities.add(new City("London", "United Kingdom"));
            allCities.add(new City("Bangkok", "Thailand"));
            allCities.add(new City("Santiago", "Chile"));
            allCities.add(new City("Singapore", "Singapore"));
            allCities.add(new City("Ankara", "Turkey"));
            allCities.add(new City("Madrid", "Spain"));
            allCities.add(new City("Rome", "Italy"));
            allCities.add(new City("Kyiv", "Ukraine"));
            allCities.add(new City("Paris", "France"));

            allCities = cityRepo.saveAll(allCities);

            List<Plane> allPlanes = new ArrayList<>();
            allPlanes.add(new Plane("Airbus", "A220"));
            allPlanes.add(new Plane("Airbus", "A300"));
            allPlanes.add(new Plane("Airbus", "A420"));
            allPlanes.add(new Plane("Boeing", "747"));
            allPlanes.add(new Plane("Boeing", "777"));
            allPlanes.add(new Plane("Boeing", "404"));
            allPlanes.add(new Plane("Boeing", "2137"));
            allPlanes.add(new Plane("Bombardier", "Challenger 300"));
            allPlanes.add(new Plane("Bombardier", "Challenger 600"));
            allPlanes.add(new Plane("Embraer", "Phenom 100"));
            allPlanes.add(new Plane("Embraer", "Phenom 300"));
            allPlanes.add(new Plane("Tupolev", "Tu-104"));
            allPlanes.add(new Plane("Tupolev", "Tu-144"));

            allPlanes = planeRepo.saveAll(allPlanes);

            Random rnd = new Random(1L);

            int cityCount = allCities.size();
            int planeCount = allPlanes.size();

            long startDate = 1622505600000L; // 2021-06-01
            long dateBounds = 10000000000L; // ~4 months
            List<Flight> flights = new ArrayList<>();



            for (int i = 0; i < 500; ++i) {
                int fromCity = rnd.nextInt(cityCount);
                int toCity = rnd.nextInt(cityCount - 1);
                if (toCity == fromCity) toCity = cityCount - 1;
                int usingPlane = rnd.nextInt(planeCount);
                long date = ((rnd.nextLong() % dateBounds) + dateBounds) % dateBounds + startDate;
                date = (date / 60000) * 60000; // round (truncate) to minutes

                flights.add(new Flight(new Timestamp(date), allCities.get(fromCity), allCities.get(toCity), allPlanes.get(usingPlane)));
            }

            flightRepo.saveAll(flights);
        };
    }
}

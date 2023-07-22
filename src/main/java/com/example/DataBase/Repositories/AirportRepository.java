package com.example.DataBase.Repositories;

import java.util.List;
import com.example.DataBase.Entities.Airport;

public interface AirportRepository {
    List<Airport> getAirports();

    List<String> getAirportsByCity(String city);
}
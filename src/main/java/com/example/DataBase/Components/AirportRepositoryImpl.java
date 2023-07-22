package com.example.DataBase.Components;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.example.DataBase.Repositories.AirportRepository;
import lombok.Cleanup;
import lombok.SneakyThrows;
import com.example.DataBase.Entities.Airport;
import com.example.DataBase.Util.util;
import org.springframework.stereotype.Component;

@Component
public class AirportRepositoryImpl implements AirportRepository {

    @Override
    @SneakyThrows
    public List<Airport> getAirports() {
        @Cleanup Connection connection = util.getConnection();
        @Cleanup Statement statement = connection.createStatement();

        @Cleanup var resultSet = statement.executeQuery("""
        SELECT * FROM airports_data;
        """);
        List<Airport> list = new ArrayList<>();

        while (resultSet.next()) {
            Airport airport = new Airport();
            airport.setCity(resultSet.getString("city"));
            airport.setCode(resultSet.getString("airport_code"));
            airport.setTimezone(resultSet.getString("timezone"));
            list.add(airport);
        }
        return list;
    }

    @Override
    @SneakyThrows
    public List<String> getAirportsByCity(String city) {
        @Cleanup Connection connection = util.getConnection();
        @Cleanup Statement statement = connection.createStatement();
        String language;
        if (Pattern.matches(".*\\p{InCyrillic}.*", city)){
            language = "ru";
        } else{
            language = "en";
        }
        @Cleanup var resultSet = statement.executeQuery(String.format("""
        SELECT * FROM airports_data
        WHERE city ->> '%s' = '%s';
        """, language, city));
        List<String> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add("airportCode: "+resultSet.getString("airport_code"));
        }

        return list;
    }
}
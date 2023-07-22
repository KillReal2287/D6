package com.example.Controllers;
import com.example.DataBase.Repositories.AirportRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class AirportController {

    @Autowired private AirportRepository airportRepository;

    @GetMapping("/availableAirports")
    public String getAllAirports() {
        return new Gson().toJson(airportRepository.getAirports());
    }

    @GetMapping("/airportCity")
    public String getAirportsByCity(@RequestParam String city) {
        return new Gson().toJson(airportRepository.getAirportsByCity(city));
    }

}
package com.example.Controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.DataBase.Repositories.CityRepository;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class CityController {

    @Autowired private CityRepository cityRepository;

    @GetMapping("/cities")
    public String getCities() {
        return new Gson().toJson(cityRepository.getCities());
    }
}
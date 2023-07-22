package com.example.Controllers;

import com.example.DataBase.Entities.ScheduleFlight;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.DataBase.Repositories.ScheduleFlightRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class ScheduleFlightController {

    @Autowired
    private ScheduleFlightRepository scheduleFlightRepository;

    @GetMapping("/inBoundSchedule")
    public String getArrivingFlightsAll(@RequestParam String airport) {
        List<ScheduleFlight> list = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            list.addAll(scheduleFlightRepository.getArrivingFlights(airport,i));
        }
        return new Gson().toJson(list);
    }

    @GetMapping("/outBoundSchedule")
    public String getDepartureFlights(@RequestParam String airport, @RequestParam int dayOfWeek) {
        List<ScheduleFlight> list = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            list.addAll(scheduleFlightRepository.getDepartingFlights(airport,i));
        }
        return new Gson().toJson(list);
    }






}
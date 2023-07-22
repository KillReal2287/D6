package com.example.DataBase.Repositories;

import java.util.List;
import com.example.DataBase.Entities.ScheduleFlight;
public interface ScheduleFlightRepository {
    List<ScheduleFlight> getArrivingFlights(String airport, int dayOfWeel);
    List<ScheduleFlight> getDepartingFlights(String airport, int dayOfWeek);
}
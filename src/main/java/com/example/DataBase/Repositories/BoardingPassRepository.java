package com.example.DataBase.Repositories;

import com.example.DataBase.Entities.CheckIn;

public interface BoardingPassRepository {
    CheckIn generateBoardingPasses(String ticketNo);
}
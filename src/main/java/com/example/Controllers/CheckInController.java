package com.example.Controllers;
import com.example.DataBase.Entities.CheckIn;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.DataBase.Repositories.BoardingPassRepository;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping(value = "/", produces = "application/json")
public class CheckInController {

    @Autowired
    private BoardingPassRepository boardingPassRepository;

    @GetMapping("/checkIn")
    public String getBoardingPasses(@RequestParam String ticketNo) {
        System.out.println(ticketNo);
        CheckIn passes;
        try {
            passes = boardingPassRepository.generateBoardingPasses(ticketNo);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return new Gson().toJson(passes);
    }

}
package com.example.DataBase.Entities;

import lombok.Data;
import org.postgresql.geometric.PGpoint;

@Data
public class Airport {

    private String code;
    private String city;
    private String timezone;

    public Airport() {}

    public Airport(String code, String city) {
        this.code = code;
        this.city = city;
    }
}
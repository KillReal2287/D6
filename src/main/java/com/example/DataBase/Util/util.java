package com.example.DataBase.Util;
import lombok.SneakyThrows;
import java.sql.Connection;
import java.sql.DriverManager;

public class util {

        static final String DB_URL = "jdbc:postgresql://127.0.0.1:5435/demo";
        static final String DB_USER = "postgres";
        static final String DB_PASSWORD = "1234";

        @SneakyThrows
        public static Connection getConnection() {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
    }


package com.example.envlog.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStamp {
    // Declare Variables
    String timeStamp;

    // Constructor to generate the current Timestamp dynamically
    public TimeStamp() {
        this.timeStamp = generateTimeStamp();
    }

    // Method to generate the current timestamp
    private String generateTimeStamp() {
        LocalDateTime timeStamp = LocalDateTime.now();
        DateTimeFormatter formatTimeStamp = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return timeStamp.format(formatTimeStamp);
    }

    // Getters for Time Stamp
    public String getTimeStamp() {
        return timeStamp;
    }
}
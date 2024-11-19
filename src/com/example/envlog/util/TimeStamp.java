package com.example.envlog.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStamp {
    // Declare Variables
    String timeStamp;

    // Constructor to Generate Timestamp
    public TimeStamp() {
        this.timeStamp = generateTimeStamp();
    }

    // Method to Generate Current Time Value
    private String generateTimeStamp() {
        LocalDateTime timeStamp = LocalDateTime.now();
        // Format the Value so that it is Readable
        DateTimeFormatter formatTimeStamp = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return timeStamp.format(formatTimeStamp);
    }

    // Getters for the TimeStamp Value
    public String getTimeStamp() {
        return timeStamp;
    }
}
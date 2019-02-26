// Get current time using possible APIs

package com.objectfrontier.training.java.pack;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DateAndTime process = new DateAndTime();
        String currentTime = process.getCurrentTime();
        log(currentTime);
    }

    private static void log(String currentTime) {
        // TODO Auto-generated method stub
        System.out.println(currentTime);
    }

    private String getCurrentTime() {
        // TODO Auto-generated method stub
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return (currentTime.format(formatter));
    }

}

// Print the current time in milliseconds and nanoseconds.

package com.objectfrontier.training.java.pack;

import java.time.Duration;
import java.time.OffsetTime;

public class MilliSecondsNanoSeconds {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MilliSecondsNanoSeconds currentTime = new MilliSecondsNanoSeconds();
        currentTime.printSecAndNano();
    }

    private void printSecAndNano() {
        // TODO Auto-generated method stub
        OffsetTime current = OffsetTime.now();
        Duration time = Duration.ofSeconds(current.getSecond());
        time = Duration.ofNanos(current.getNano());
        long milliseconds = time.toMillis();
        long nanoSec = time.getNano();
        System.out.println("Milli Seconds " + milliseconds + "\nNano Second " + nanoSec);
    }

}

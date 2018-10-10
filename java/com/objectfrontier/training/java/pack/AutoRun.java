// Print a message every 10 seconds using TimerTask API with time, like "6:11 AM Monday, 10 September 2018: Hi I am auto runner"

package com.objectfrontier.training.java.pack;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class AutoRun {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AutoRun task = new AutoRun();
        task.start();
    }

    private void start() {
        // TODO Auto-generated method stub
        Timer t = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                LocalDateTime current = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm EEEE, dd L yyyy:");
                System.out.println(current.format(formatter) + " Hi I am auto runner");
                //start();
            }
        };
        t.schedule(task, 0, 10000);
    }

}

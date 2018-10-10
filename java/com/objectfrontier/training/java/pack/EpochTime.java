// Print the Epoch time

package com.objectfrontier.training.java.pack;

import java.util.Date;

public class EpochTime {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EpochTime time = new EpochTime();
        time.printEpochTime();
    }

    private void printEpochTime() {
        // TODO Auto-generated method stub
        Date epochTime = new Date();
        System.out.println(epochTime.getTime());
    }

}

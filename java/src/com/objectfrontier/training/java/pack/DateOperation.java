// Date difference - Find the difference between two dates.

package com.objectfrontier.training.java.pack;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class DateOperation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DateOperation dates = new DateOperation();
        dates.findAndPrintDiffrence();
    }

    private void findAndPrintDiffrence() {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        String date1 = scan.next();
        String date2 = scan.next();
        scan.close();
        int[] splitdate = splitdate(date1);
        LocalDate dateOne = LocalDate.of(splitdate[0], splitdate[1], splitdate[2]);
        splitdate = splitdate(date2);
        LocalDate dateTwo = LocalDate.of(splitdate[0], splitdate[1], splitdate[2]);
        Period diffOfDate = findDifference(dateOne,dateTwo);
        System.out.println("Year" + diffOfDate.getYears() + " Month" + diffOfDate.getMonths() + " Days" + diffOfDate.getDays());
    }

    private Period findDifference(LocalDate dateOne, LocalDate dateTwo) {
        // TODO Auto-generated method stub
        Period diffOfDate = Period.between(dateOne, dateTwo);
        return diffOfDate;
    }

    private int[] splitdate(String date1) {
        // TODO Auto-generated method stub
        String[] splitDate = date1.split("\\.");
        int[] split = new int[splitDate.length];
        int i=0;
        for (String component : splitDate) {
            split[i] = Integer.parseInt(component);
            i++;
        }
        return split;
    }

}

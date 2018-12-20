// ISO standard - Format and print current date into ISO date format

package com.objectfrontier.training.java.pack;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatDate {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FormatDate date = new FormatDate();
        String formatedIso = date.getIsoFormat();
        print(formatedIso);
    }

    private String getIsoFormat() {
        // TODO Auto-generated method stub
        LocalDate todayDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        String isoFormated = todayDate.format(formatter);
        return isoFormated;
    }

    private static void print(String formatedIso) {
        // TODO Auto-generated method stub
        System.out.println(formatedIso);
    }

}

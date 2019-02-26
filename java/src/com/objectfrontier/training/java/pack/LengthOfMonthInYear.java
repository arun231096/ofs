// given year, print the length of each month within that year

package com.objectfrontier.training.java.pack;

import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class LengthOfMonthInYear {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LengthOfMonthInYear process = new LengthOfMonthInYear();
        process.calculateForYear();
    }

    private void calculateForYear() {
        // TODO Auto-generated method stub
        int givenYear = getYear();
        printLengthofTheMonth(givenYear);

    }

    private void printLengthofTheMonth(int givenYear) {
        // TODO Auto-generated method stub
        int monthCount = 1;
        while (monthCount <= 12) {
        YearMonth month = YearMonth.of(givenYear, monthCount);
        StringBuilder monthWithLength = new StringBuilder(month.getMonth()
                                                               .getDisplayName(TextStyle.FULL, Locale.getDefault())
                                                               + " "
                                                               + month.lengthOfMonth());
        System.out.println(monthWithLength);
        monthCount++;
        }
    }

    private int getYear() {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
        scan.close();
        return year;
    }

}

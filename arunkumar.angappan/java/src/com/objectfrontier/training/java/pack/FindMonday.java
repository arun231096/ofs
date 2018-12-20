// For a given month of the current year, lists all of the Mondays in that month with date in mm-dd-yyyy format

package com.objectfrontier.training.java.pack;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class FindMonday {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FindMonday inMonth = new FindMonday();
        inMonth.findByYear();
    }

    private void findByYear() {
        // TODO Auto-generated method stub
        Year currentYear = Year.now();
        String listMonday = getMondaysInYear(currentYear);
        print(listMonday);
    }

    private String getMondaysInYear(Year currentYear) {
        // TODO Auto-generated method stub
        StringBuilder mondays = new StringBuilder();
        DayOfWeek day = DayOfWeek.MONDAY;
        int year = currentYear.getValue();
        Month givenMonth = getMonth(year);
        YearMonth cuurentMonth = YearMonth.of(year, givenMonth);
        for (int i = 1; i <= cuurentMonth.lengthOfMonth(); i++) {

            LocalDate dateday = cuurentMonth.atDay(i);
            if (dateday.getDayOfWeek() == day) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                mondays.append(dateday.format(formatter).toString() + "\n");
            }
        }
        return mondays.toString();
    }

    private Month getMonth(int year) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        String getmonth = scan.next();
        scan.close();
        int monthCount = 1;
        while (monthCount <= 12) {
            YearMonth month = YearMonth.of(year, monthCount);
            String currentMonth = month.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
            if (currentMonth.equalsIgnoreCase(getmonth)) {
                return (month.getMonth());
            }
            monthCount++;
        }
        print("This is not a Month");
        System.exit(1);
        return null;
    }
    private void print(String message) {
        // TODO Auto-generated method stub
        System.out.println(message);
    }
}

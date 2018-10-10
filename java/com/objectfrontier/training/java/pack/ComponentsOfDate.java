// Print the components of the current date

package com.objectfrontier.training.java.pack;


import java.time.LocalDate;
import java.time.Month;

public class ComponentsOfDate {

    public static void main(String[] args) {
        try {
            ComponentsOfDate o = new ComponentsOfDate();
            o.run(args);
        } catch (Throwable t) {
            log(t);
        }
    }

    private void run(String[] args) throws Exception {

       LocalDate currentDate = LocalDate.now();
       printComponents(currentDate);
    }

    private void printComponents(LocalDate currentDate) {

        Integer year = currentDate.getYear();
        Month month = currentDate.getMonth();
        Integer date = currentDate.getDayOfMonth();
        log("Year : %s\n", year.toString());
        log("Month : %s\n", month.toString());
        log("Date : %s", date.toString());
    }

    private static void log(Throwable t) {
        t.printStackTrace(System.err);
    }

    private static void log(String format, String vals) {
        System.out.format(format, vals);
    }
}

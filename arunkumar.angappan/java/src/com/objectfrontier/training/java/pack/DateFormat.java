// Formatting current date to following formats: 2001-07-04T12:08:56.235-0700 and 2001.07.04 at 12:08:56 PDT

package com.objectfrontier.training.java.pack;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormat {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DateFormat dateAndTime = new DateFormat();
        dateAndTime.formatAndPrint();
    }

    private void formatAndPrint() {
        // TODO Auto-generated method stub
        String formatedDateAndTime = getFormatedDate();
        log("%s \n", formatedDateAndTime);
        String timeWithZone = getZoneFormat();
        log("%s", timeWithZone);
    }

    private String getFormatedDate() {
        // TODO Auto-generated method stub
        OffsetDateTime dateandtime = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        return dateandtime.format(formatter);
    }

    private String getZoneFormat() {
        // TODO Auto-generated method stub
        ZonedDateTime zoneTime = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.mm.dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH.mm.ss z");
        String timeWithZone = zoneTime.format(formatter) + " at " + zoneTime.format(formatter2);
//                                                         + " " + zoneTime.getZone().getId();
        return timeWithZone;
    }

    private void log(String string, String formatedDateAndTime) {
        // TODO Auto-generated method stub
        System.out.format(string, formatedDateAndTime);
    }
}

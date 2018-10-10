package com.objectfrontier.training.java.col;

import java.util.List;
import java.util.stream.Collectors;

public class AvgAgeOfPerson {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Person> listOfPerson = Person.createRoster();
        double avg = getAvgAge(listOfPerson);
        log(avg);
    }

    private static double getAvgAge(List<Person> listOfPerson) {
        // TODO Auto-generated method stub
        double avg = listOfPerson.stream().map(input -> input.getAge())
                                 .collect(Collectors.averagingInt(age -> age));
        return avg;
    }

    private static void log(double avg) {
        // TODO Auto-generated method stub
        System.out.println(avg);
    }
}

package com.objectfrontier.training.java.col;

import java.util.List;

public class DisplayPersonsDetails {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<Person> personList = Person.createRoster();
        log(personList);
    }

    private static void log(List<Person> personList) {
        // TODO Auto-generated method stub
        personList.forEach(person -> person.printPerson());
    }

}

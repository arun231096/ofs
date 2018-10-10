package com.objectfrontier.training.java.col;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class CollectionOperation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CollectionOperation onPersons = new CollectionOperation();
        onPersons.start();
    }

    private void start() {
        // TODO Auto-generated method stub
        //Create a roster from the Person class and add each Person in the newRoster to the existing list and print the new roster List
        List<Person> roster = Person.createRoster();
        List<Person> newroster = addNewRoster();
        roster = appendRoster(roster, newroster);

        //Print the number of Persons in roster list after the above addition
        printNumberOfPerson(roster);

        //Remove the all the Person in the roster list
        roster.removeAll(roster);

    }

    private void printNumberOfPerson(List<Person> roster) {
        // TODO Auto-generated method stub
        System.out.println("Number of Persons :-" + roster.size());
    }

    private List<Person> appendRoster(List<Person> roster, List<Person> newroster) {
        // TODO Auto-generated method stub
        roster.addAll(newroster);
        return roster;
    }

    private List<Person> addNewRoster() {
        // TODO Auto-generated method stub

        ArrayList<Person> newRoster = new ArrayList<>(4);
        newRoster.add(new Person("John",
                                 IsoChronology.INSTANCE.date(1980, 6, 20),
                                 Person.Sex.MALE,
                                 "john@example.com"));
        newRoster.add(new Person("Jade",
                                 IsoChronology.INSTANCE.date(1990, 7, 15),
                                 Person.Sex.FEMALE,
                                 "jade@example.com"));
        newRoster.add(new Person("Donald",
                                 IsoChronology.INSTANCE.date(1991, 8, 13),
                                 Person.Sex.MALE,
                                 "donald@example.com"));
        newRoster.add(new Person("Bob",
                                 IsoChronology.INSTANCE.date(2000, 9, 12),
                                 Person.Sex.MALE,
                                 "bob@example.com"));

        return newRoster;
    }

}

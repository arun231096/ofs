package com.objectfrontier.training.java.col;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RosterOperation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RosterOperation operation = new RosterOperation();
        operation.start();
    }

    private void start() {
        // TODO Auto-generated method stub
        List<Person> roster = Person.createRoster();
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
        //new roster added in the roster list
        roster = addperson(roster, newRoster);
        log("Added Person List", roster);
        //Remove the only Person who are in the newRoster from the roster list
        roster = removeRosterList (roster, newRoster);
        log("\nRemoved persons who are in newRoster", roster);
        //Remove the following Person from the roster
        Person addedperson = new Person("Bob", IsoChronology.INSTANCE.date(2000, 9, 12), Person.Sex.MALE, "bob@example.com");
        roster = removeSingleRoster(roster, addedperson);
        log("\nRemoving the person Bob in the list", roster);
    }

    private List<Person> removeSingleRoster(List<Person> roster, Person addedperson) {
        // TODO Auto-generated method stub
        Iterator<Person> list = roster.iterator();
        while (list.hasNext()) {
            if (list.next().getEmailAddress().equals(addedperson.getEmailAddress())) {
                list.remove();
            }
        }
        return roster;
    }

    private List<Person> removeRosterList(List<Person> roster, ArrayList<Person> newRoster) {
        // TODO Auto-generated method stub
        //roster.retainAll(newRoster); // Retains the elements from the list which contains specified collections
        roster.removeAll(newRoster); // removes the elements from the list which contains collections
        return roster;
    }

    private List<Person> addperson(List<Person> roster, ArrayList<Person> newRoster) {
        // TODO Auto-generated method stub
        roster.addAll(newRoster);
        return roster;
    }

    private void log(String string, List<Person> roster) {
        // TODO Auto-generated method stub
        System.out.println(string);
        roster.forEach(person -> person.printPerson());
    }
}

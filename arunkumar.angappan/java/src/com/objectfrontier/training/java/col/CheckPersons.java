package com.objectfrontier.training.java.col;

import java.time.chrono.IsoChronology;
import java.util.List;

public class CheckPersons {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Person> personList = Person.createRoster();
        CheckPersons inList = new CheckPersons();
        inList.findPerson(personList);

    }

    private void findPerson(List<Person> personList) {
        // TODO Auto-generated method stub
        Person newPerson = new Person("Bob", IsoChronology.INSTANCE.date(2000, 9, 12), Person.Sex.MALE, "bobsd@example.com");
        // Version 1
//        personList.forEach(person -> {
//            if (person.getEmailAddress().contains(newPerson.getEmailAddress())) {
//                System.out.println("Person Available");
//            }
//        });
        // version 2
        if (personList.stream().anyMatch(person -> person.getEmailAddress().contains(newPerson.getEmailAddress()))) {
            System.out.println("Person Available");
        } else {
            System.out.println("Person Not Avaialble");
        }
    }

}

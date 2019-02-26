package com.objectfrontier.training.java.col;

import java.util.Iterator;
import java.util.List;

public class IterateRoster {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Person> listOfPersons = Person.createRoster();
        IterateRoster persons = new IterateRoster();
        persons.printPersonList(listOfPersons);

    }

    private void printPersonList(List<Person> listOfPersons) {
        // TODO Auto-generated method stub
        Iterator<Person> personDetails = listOfPersons.iterator();
        while (personDetails.hasNext()) {
            personDetails.next().printPerson();
        }
    }

}

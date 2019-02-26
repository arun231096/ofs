package com.objectfrontier.training.java.col;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortPersonsByAge {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Person> personsList = Person.createRoster();
        SortPersonsByAge persons = new SortPersonsByAge();
        List<Person> filteredPersons = persons.sortByAge(personsList);
        persons.log(filteredPersons);

    }

    private List<Person> sortByAge(List<Person> personsList) {

        Comparator<Person> compare = (o1, o2) -> {
            // TODO Auto-generated method stub
          return (Person.compareByAge(o1, o2));
        };
        Collections.sort(personsList, compare);
        return personsList;
    }

    private void log(List<Person> filteredPersons) {
        // TODO Auto-generated method stub
        filteredPersons.forEach(person -> person.printPerson());
    }

}

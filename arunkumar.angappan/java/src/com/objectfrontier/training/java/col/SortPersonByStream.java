package com.objectfrontier.training.java.col;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortPersonByStream {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Person> personsList = Person.createRoster();
        SortPersonByStream persons = new SortPersonByStream();
        List<Person> filteredPersons = persons.sortByAge(personsList);
        persons.log(filteredPersons);

    }

    private List<Person> sortByAge(List<Person> personsList) {
        // TODO Auto-generated method stub
        Comparator<Person> compare = (o1, o2) -> {
            // TODO Auto-generated method stub
          return (Person.compareByAge(o1, o2));
        };
        List<Person> filterByAge = personsList.stream().sorted(compare).collect(Collectors.toList());
        return filterByAge;
    }

    private void log(List<Person> filteredPersons) {
        filteredPersons.forEach(person -> person.printPerson());
    }
}

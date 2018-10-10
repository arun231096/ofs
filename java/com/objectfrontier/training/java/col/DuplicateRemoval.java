package com.objectfrontier.training.java.col;

import java.time.chrono.IsoChronology;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DuplicateRemoval {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Person> persons = Person.createRoster();
        persons.add(new Person("Bob",
                     IsoChronology.INSTANCE.date(2000, 9, 12),
                     Person.Sex.MALE,
                     "bob@example.com"));
        Set<Person> listOfPersons = removeDuplicate(persons);
        log(listOfPersons);

    }

    private static Set<Person> removeDuplicate(List<Person> persons) {
        // TODO Auto-generated method stub
        // Version 1
//        Comparator<Person> compare = (o1, o2) -> {
//            // TODO Auto-generated method stub
//          if (o1.getEmailAddress().equals(o2.getEmailAddress())) {
//              return 0;
//          }
//          return 1;
//        };
        // version 2
//        Set<Person> withOutDuplicate = new TreeSet<>((o1, o2) -> {
//            // TODO Auto-generated method stub
//            if (o1.getEmailAddress().equals(o2.getEmailAddress())) {
//                return 0;
//            }
//            return 1;
//        });
//        withOutDuplicate.addAll(persons);
        // Version 3
        Set<Person> withOutDuplicate = persons.stream()
                                              .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person :: getEmailAddress))));
        return withOutDuplicate;
    }

    private static void log(Set<Person> listOfPersons) {
        // TODO Auto-generated method stub
        listOfPersons.forEach(person -> person.printPerson());
    }
}

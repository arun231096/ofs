package com.objectfrontier.training.java.pack;

import java.util.Comparator;
import java.util.List;

import com.objectfrontier.training.java.col.Person;

public class Comparsion {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Comparsion process = new Comparsion();
        process.start();
    }

    private void start() {
        // TODO Auto-generated method stub
        List<Person> roster = Person.createRoster();
        rosterWithComparable(roster);
        rosterWithComparator(roster);
    }

    private void rosterWithComparator(List<Person> roster) {
        // TODO Auto-generated method stub
        Comparator<Person> compare = (o1, o2) -> {
            // TODO Auto-generated method stub
          return (Person.compareByAge(o1, o2));
        };
        roster.sort(compare);
        roster.forEach(person -> person.printPerson());
    }

    private void rosterWithComparable(List<Person> roster) {
        // TODO Auto-generated method stub
        Comparable<Person> compare = new Comparable<Person>() {
            
            @Override
            public int compareTo(Person o) {
                // TODO Auto-generated method stub
                return 0;
            }
        };
    }

}

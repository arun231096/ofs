package com.objectfrontier.training.java.col;

import java.util.List;
import java.util.stream.Collectors;

import com.objectfrontier.training.java.col.Person.Sex;

public class FilterGenderBasedPerson {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<Person> personList = Person.createRoster();
        FilterGenderBasedPerson persondetail = new FilterGenderBasedPerson();
        List<Person> MalePersonDetails = persondetail.getMalePersonDetails(personList);
        persondetail.findFirstperson(MalePersonDetails);
        persondetail.findLastPerson(MalePersonDetails);
        persondetail.findRandomPerson(MalePersonDetails);
    }

    private List<Person> getMalePersonDetails(List<Person> personList) {
        // TODO Auto-generated method stub

        List<Person> filterBasedMale = personList.stream().filter(person -> { return (person.gender.equals(Sex.MALE));})
                                                 .collect(Collectors.toList());
        return (filterBasedMale);

    }

    private void findRandomPerson(List<Person> personList) {
        // TODO Auto-generated method stub

        Person randomPerson = personList.stream().findAny().get();
        log(randomPerson);
    }

    private void findLastPerson(List<Person> personList) {
        // TODO Auto-generated method stub

        Person lastPerson = personList.get(personList.size() - 1);
        log(lastPerson);

    }

    private void findFirstperson(List<Person> personList) {
        // TODO Auto-generated method stub
        // Version 1 ApI referenced
        //System.out.println("First Person " + filterBasedMale.stream()
                                                              //.findFirst()
                                                              //.get()
                                                              //.getName());
        // Version 2 refined and without ApI methods
        Person firstPerson = personList.get(0);
        log(firstPerson);
    }

    private void log(Person presonDetail) {
        // TODO Auto-generated method stub
        presonDetail.printPerson();
    }

}

package com.objectfrontier.training.java.col;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimalPerson {

    String name;
    String email;

    public static void main(String[] args) {

        MinimalPerson person = new MinimalPerson();
        List<MinimalPerson> MinimalPersonDetails = person.getMinimalPerson();
        person.printMinimalPersonDetails(MinimalPersonDetails);

    }

    private List<MinimalPerson> getMinimalPerson() {
        // TODO Auto-generated method stub
        List<Person> perosnDetails = Person.createRoster();
        Function<Person, MinimalPerson> getminimalPerson = (input) -> {
            MinimalPerson dto = new MinimalPerson();
            dto.name = input.getName();
            dto.email = input.getEmailAddress();
            return dto;
         };
        List <MinimalPerson> minimalperson = perosnDetails.stream()
                                                         .map(getminimalPerson)
                                                         .collect(Collectors.toList());
        return(minimalperson);
    }

    private void printMinimalPersonDetails(List<MinimalPerson> minimalperson) {
        // TODO Auto-generated method stub
        minimalperson.forEach(person -> System.out.println(person.name + ", " + person.email));

    }

}

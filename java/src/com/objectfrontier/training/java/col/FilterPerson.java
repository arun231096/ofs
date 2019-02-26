package com.objectfrontier.training.java.col;

import java.util.List;
import java.util.stream.Collectors;

import com.objectfrontier.training.java.col.Person.Sex;

interface filter {
    List<Person> filtePersons(List<Person> filterPerson);
}
public class FilterPerson /*implements filter*/{

    public static void main(String[] args) {

        List<Person> personDetails = Person.createRoster();
        FilterPerson listOfPersons = new FilterPerson();
        List<Person> filteredPerson = listOfPersons.getFilteredPerson(personDetails);
        listOfPersons.log(filteredPerson);
    }

    private List<Person> getFilteredPerson(List<Person> personDetails) {
        // TODO Auto-generated method stub


//      //version 1 Normal Filtering
//      filter = fltr.filtePersons(filterPerson);
//      filter.forEach(e -> System.out.println(e.name));
//
//      // version 2 improvised using lambda expression
//      filter filtr2 = filterPerson1 -> {
//          // TODO Auto-generated method stub
//          List<Person> finallyFiltered = new ArrayList<Person>(filterPerson1.size());
//          for (Person emp : filterPerson1) {
//              if(emp.getAge() > 21 && emp.getGender().equals(Sex.MALE)){
//                  finallyFiltered.add(emp);
//              }
//          }
//          return finallyFiltered;
//      };
//      filter = filtr2.filtePersons(filterPerson);
//      filter.forEach(e -> System.out.println(e.name));

      //version 3 using Stream and lambda expression
      List<Person> filter = personDetails.stream().filter((input) -> { return input.getAge() > 21 && input.getGender().equals(Sex.MALE); })
                                         .collect(Collectors.toList());
      return filter;


    }

    private void log(List<Person> filteredPerson) {
        // TODO Auto-generated method stub
        filteredPerson.forEach(person -> { person.printPerson();});
    }
}

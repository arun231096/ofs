package com.objectfrontier.training.webservices.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.objectfrontier.training.webservices.pojo.Address;
import com.objectfrontier.training.webservices.pojo.Person;

public class ReadCsv {

    List<Person> readAllPersonData(Path filepath) throws IOException {
        // TODO Auto-generated method stub
        List<Person> ListOfpersonData = new ArrayList<>();
        List<String> listOfPerson = Files.readAllLines(filepath);
        for (String personData : listOfPerson) {
            String personDetails[] =personData.split("\\,");
            Person person = new Person();
            Address address = new Address();
            person.setFirstname(personDetails[0]);
            person.setLastname(personDetails[1]);
            person.setEmail(personDetails[2]);
            person.setDob(personDetails[3]);
            person.setCreatedDate(Timestamp.from(Instant.now()));
            address.setStreet(personDetails[4]);
            address.setCity(personDetails[5]);
            address.setPostal_code(Integer.parseInt(personDetails[6]));
            if (personDetails.length > 7) {
                person.setId(Integer.parseInt(personDetails[7]));
                address.setId(Integer.parseInt(personDetails[8]));
            }
            person.setAddress(address);
            ListOfpersonData.add(person);
        }
        return ListOfpersonData;
    }
}

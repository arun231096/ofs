package com.objectfrontier.training.webservices.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.objectfrontier.training.webservices.model.Address;
import com.objectfrontier.training.webservices.model.Person;

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
            person.setPassword(personDetails[3]);
            person.setIsadmin(Boolean.parseBoolean(personDetails[4]));
            person.setDob(personDetails[5]);
            person.setCreatedDate(Timestamp.from(Instant.now()));
            address.setStreet(personDetails[6]);
            address.setCity(personDetails[7]);
            address.setPostal_code(Integer.parseInt(personDetails[8]));
            if (personDetails.length > 9) {
                person.setId(Integer.parseInt(personDetails[9]));
                address.setId(Integer.parseInt(personDetails[10]));
            }
            person.setAddress(address);
            ListOfpersonData.add(person);
        }
        return ListOfpersonData;
    }
}

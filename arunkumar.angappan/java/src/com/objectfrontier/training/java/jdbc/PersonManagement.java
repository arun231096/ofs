package com.objectfrontier.training.java.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import com.objectfrontier.training.java.jdbc.pojo.Address;
import com.objectfrontier.training.java.jdbc.pojo.Person;
import com.objectfrontier.training.java.jdbc.service.AddressService;
import com.objectfrontier.training.java.jdbc.service.PersonService;

public class PersonManagement {

    public static void main(String[] args) throws SQLException {

        Connection con = ConnectionManagement.getConnection();
        AddressService addressService = new AddressService();
        PersonService personService = new PersonService();
        Person person = new Person();
        Address address = new Address();
        person.setId(3);
        person.setName("Arunkumar A");
        person.setEmail("arunak283933@ofs");
        person.setDob(Date.valueOf("1996-10-23"));
        person.setCreatedDate(Timestamp.from(Instant.now()));
        address.setCity("Erode");
        address.setPostal_code(60113);
        address.setStreet("arunnagar");
        address.setId(3);
        person.setAddress(address);
//        try {
//        person = personService.read(con, 1, true);
//        if (person != null) {
//            System.out.println(person.getName() + " " + person.getAddress().getCity());
//        } else {
//            System.out.println("Not Updated");
//        }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//        if (addressService.update(con, person.getAddress())) {
//            System.out.println(" " +person.getName() + person.getAddress().getCity());
//        }
//        try {
//        if (personService.delete(con, person)) {
//            System.out.println("Updated");
//        } else {
//            System.out.println("Cannot Updated");
//        }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        List<Address> list = addressService.readAll(con);
//        if (list.isEmpty()) {
//            System.out.println("Not Updated");
//        } else {
//            list.forEach(e-> System.out.println(e.getId() + " " + e.getCity()));
//        }
    }
}

package com.objectfrontier.training.java.jdbc;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import com.objectfrontier.training.java.jdbc.pojo.Address;
import com.objectfrontier.training.java.jdbc.pojo.Person;

public class PersonManagement {

    private Scanner scan;
    private PersonService service;
    private Person person;
    private Address address;
    public static void main(String[] args) throws SQLException {

        PersonManagement process = new PersonManagement();
        process.start();
    }

    private void start() throws SQLException {

        String choise;
        scan = new Scanner(System.in);
        System.out.println("Enter choise of create, read, update and delete");
        choise = scan.next();
        if (choise.equalsIgnoreCase("create")) {
            createPerson();
        } else if (choise.equalsIgnoreCase("read")) {
            readPerson();
        } else if (choise.equalsIgnoreCase("update")) {
            updatePerson();
        } else if (choise.equalsIgnoreCase("delete")) {
            deletePerson();
        } else {
            System.out.println("Input Error");
        }
    }

    private void deletePerson() {
        // TODO Auto-generated method stub

    }

    private void updatePerson() {
        // TODO Auto-generated method stub

    }

    private void readPerson() throws SQLException {

        int id = 0;
        String withAddress = null;
        scan = new Scanner(System.in);
        id = scan.nextInt();
        withAddress = scan.next();
        if (withAddress.equalsIgnoreCase("yes")) {
            service.read(id, true);
        } else if (withAddress.equalsIgnoreCase("no")) {
            service.read(id, false);
        }

    }

    private void createPerson() throws SQLException {

        person = new Person();
        scan = new Scanner(System.in);
        person.setName(scan.next());
        person.setEmail(scan.next());
        person.setDob(Date.valueOf(scan.next()));
        address.setStreet(scan.next());
        address.setCity(scan.next());
        address.setPostal_code(scan.nextInt());
        scan.close();
//        System.out.println(name+email+street+city+pincode+dob);
        service = new PersonService();
        service.create(person, address);
    }

}

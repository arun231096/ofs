package com.objectfrontier.training.webservices;

import java.io.IOException;
import java.sql.SQLException;

public class PersonManagement {

    public static void main(String[] args) throws SQLException, IOException {

////        Connection con = ConnectionManagement.getConnection();
//        PersonService personService = new PersonService();
//        Person person = new Person();
//        Address address = new Address();
//        person.setFirstname("Arunkumar");
//        person.setLastname("Angappan");
//        person.setDob("23-10-1997");
//        person.setEmail("arun@gmail.com");
//        person.setCreatedDate(Timestamp.from(Instant.now()));
//        address.setCity("Chithode");
//        address.setStreet("Chennai Street");
//        address.setPostal_code(638183);
//        address.setId(2);
//        person.setAddress(address);
//        Resource dbResource = new Resource();
//        dbResource.createConnection();
//        System.out.println(dbResource.getConnection().hashCode());
//        try {
//            dbResource.getConnection().setAutoCommit(false);
//            personService.create(dbResource, person);
//            dbResource.getConnection().commit();
//        } catch (Exception e) {
//            dbResource.getConnection().rollback();
//            dbResource.getConnection().commit();
//            System.out.println(e.getMessage());
//        }
//        try {
////            List <Person> personList = personService.readAll(con);
////            List <Address> addressList = personService.getAddress().readAll(con);
////            personList.forEach(e-> System.out.println(e.getId()));
////            addressList.forEach(e-> System.out.println(e.getId()));
//            con.setAutoCommit(false);
//            person = personService.create(con, person);
////            person.setId(4);
////            person = personService.read(con, person.getId(), true);
////            if (personService.update(con, person)) {
////                System.out.println(person.getFirstname() + person.getAddress().getCity());
////            }
////            con.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
////            con.rollback();
//        }
    }
}

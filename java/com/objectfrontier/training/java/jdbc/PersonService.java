package com.objectfrontier.training.java.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.objectfrontier.training.java.jdbc.pojo.Address;
import com.objectfrontier.training.java.jdbc.pojo.Person;

public class PersonService {

    Person person;
    AddressService addr;
    private Connection con;
    private PreparedStatement createPerson;
    private PreparedStatement readPerson;
//    private PreparedStatement checkAddress;
    private PreparedStatement updatePersonName;
    private PreparedStatement updatePersonEmail;
    private PreparedStatement updatePersonDob;
    private PreparedStatement deletePerson;
//    private PreparedStatement readAllPerson;
    private ResultSet result;

    public PersonService() throws SQLException {

         addr = new AddressService();
         person = new Person();
         setCon(ConnectionManagement.getConnection());
         createPerson = con.prepareStatement("INSERT INTO person (name, email, address_id, birth_date, created_date)"
                                           + "VALUES (?,?,?,?,?)");
         readPerson =  con.prepareStatement("SELECT name, email, address_id, brith_date, created_date"
                                            + "FROM person"
                                           + "WHERE id = ?");
//         checkAddress = con.prepareStatement("SELECT address_id "
//                                             + "FROM person "
//                                            + "WHERE id = ?");
         updatePersonName = con.prepareStatement("UPDATE person "
                                                  + "SET name = ?"
                                                + "WHERE id = ?");
         updatePersonEmail = con.prepareStatement("UPDATE person "
                                                   + "SET email = ?"
                                                 + "WHERE id = ?");
         updatePersonDob = con.prepareStatement("UPDATE person "
                                                 + "SET birth_date = ?"
                                               + "WHERE id = ?");
         deletePerson = con.prepareStatement("DELETE person "
                                            + "WHERE id = ?");
//         readAllPerson = con.prepareStatement("SELECT name, email, address_id, brith_date, created_date "
//                                              + "FROM person");
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void create(Person person, Address address) throws SQLException {

//        System.out.println(name+email+street+city+postal_code+birth_date);
        int address_id = addr.create(address);
        System.out.println(address_id);
        LocalDateTime createdDate = LocalDateTime.now();
        Timestamp stamp = Timestamp.valueOf(createdDate);
        createPerson.setString(1, person.getName());
        createPerson.setString(2, person.getEmail());
        createPerson.setInt(3, address_id);
        createPerson.setDate(4, person.getDob());
        createPerson.setTimestamp(5, stamp);
        try {
        if (createPerson.executeUpdate() > 0) {
            System.out.println("Person Created");
        }
        } catch (Exception e) {
            System.out.println("Dupilcate Entry");
        }
    }

    public void read (int id, boolean includeAddress) throws SQLException {

        readPerson.setInt(1, id);
        result = readPerson.executeQuery();
        if (includeAddress == true) {
            if (result.next()) {
                addr.read(result.getInt("address_id"));
                person.setName(result.getString("name"));
                person.setEmail(result.getString("email"));
                person.setDob(result.getDate("birth_date"));
                Timestamp stamp = result.getTimestamp("created_date");
                person.setCreatedDate(stamp.toLocalDateTime());
            }
        } else {
            if (result.next()) {
                person.setName(result.getString("name"));
                person.setEmail(result.getString("email"));
                person.setDob(result.getDate("birth_date"));
                Timestamp stamp = result.getTimestamp("created_date");
                person.setCreatedDate(stamp.toLocalDateTime());
            }
        }
    }

    public void update (int id, String updateFiled, String field) throws SQLException {

        if (field.equals("name")) {
            updatePersonName.setString(1, updateFiled);
            updatePersonName.setInt(2, id);
            if (updatePersonName.execute()) {
                System.out.println("Name Updated");
            } else {
                System.out.println("Error in updation");
            }
        } else if (field.equals("email")) {
            updatePersonName.setString(1, updateFiled);
            updatePersonName.setInt(2, id);
            if (updatePersonEmail.execute()) {
                System.out.println("Name Updated");
            } else {
                System.out.println("Error in updation");
            }
        } else if (field.equals("dob")) {
            Date dob = Date.valueOf(updateFiled);
            updatePersonName.setDate(1, dob);
            updatePersonName.setInt(2, id);
            if (updatePersonDob.execute()) {
                System.out.println("Name Updated");
            } else {
                System.out.println("Error in updation");
            }
        } else {
            System.out.println("UPDATE ERROR Invalid Input");
        }
    }

    public void delete(int id) throws SQLException {

    	deletePerson.setInt(1, id);
    	if (deletePerson.execute()) {
    		System.out.println("Person Deleted");
    	} else {
    		System.out.println("Error in deletion");
    	}
    }

    public void close () throws SQLException {

    	con.close();
    	readPerson.close();
    	updatePersonDob.close();
    	updatePersonEmail.close();
    	updatePersonName.close();
    	createPerson.close();
    }
}

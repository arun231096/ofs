package com.objectfrontier.training.java.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class PersonService {

    String name;
    String email;
    Date dob;
    LocalDateTime createdDate;
    int address_id;
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

    public void create(String name, String email, Date birth_date, String street, String city, int postal_code) throws SQLException {

        int address_id = addr.create(street, city, postal_code);
        createdDate = LocalDateTime.now();
        Timestamp stamp = Timestamp.valueOf(createdDate);
        createPerson.setString(1, name);
        createPerson.setString(2, email);
        createPerson.setInt(3, address_id);
        createPerson.setDate(4, birth_date);
        createPerson.setTimestamp(5, stamp);
        if (createPerson.execute()) {
            System.out.println("Person Created");
        } else {
            System.out.println("Duplicate value cannot be insert");
        }
    }

    public void read (String email, boolean includeAddress) throws SQLException {

        result = readPerson.executeQuery();
        if (includeAddress == true) {
            addr.read(result.getInt("address_id"));
            name = result.getString("name");
            email = result.getString("email");
            dob = result.getDate("birth_date");
            Timestamp stamp = result.getTimestamp("created_date");
            createdDate = stamp.toLocalDateTime();
        } else {
            name = result.getString("name");
            email = result.getString("email");
            dob = result.getDate("birth_date");
            Timestamp stamp = result.getTimestamp("created_date");
            createdDate = stamp.toLocalDateTime();
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

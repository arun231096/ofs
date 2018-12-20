package com.objectfrontier.training.java.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.objectfrontier.training.java.jdbc.pojo.Address;
import com.objectfrontier.training.java.jdbc.pojo.Person;

public class PersonService {

    AddressService address;
    private PreparedStatement createPerson;
    private PreparedStatement readPerson;
    private PreparedStatement updatePersondetail;
    private PreparedStatement deletePerson;
    private PreparedStatement readAllPerson;

    public Person create(Connection con, Person person) throws SQLException, ServiceException {

        createPerson = con.prepareStatement( new StringBuilder()
                .append("INSERT INTO person (name, email, address_id, birth_date, created_date) ")
                .append("VALUES (?,?,?,?,?) ").toString(), Statement.RETURN_GENERATED_KEYS);

        address = new AddressService();
            con.setAutoCommit(false);
            person.setAddress(address.create(con, person.getAddress()));
            if (person.getAddress().getId() > 0) {
                createPerson.setString(1, person.getName());
                createPerson.setString(2, person.getEmail());
                createPerson.setLong(3, person.getAddress().getId());
                createPerson.setDate(4, person.getDob());
                createPerson.setTimestamp(5, person.getCreatedDate());
                if (createPerson.executeUpdate() > 0) {
                    ResultSet resultSet = createPerson.getGeneratedKeys();
                    resultSet.next();
                    person.setId(resultSet.getLong(1));
                    con.commit();
                    createPerson.close();
                    return person;
                }
            } else {
                throw new ServiceException("Cannot create Address");
            }
            return person;
    }

    public List<Person> readAll (Connection con) throws SQLException {

        readAllPerson = con.prepareStatement( new StringBuilder()
                .append("SELECT person.id, name, email, address_id, birth_date, created_date ")
                .append("FROM person ").toString());

        List<Person> personList = new ArrayList<>();
        ResultSet result = readAllPerson.executeQuery();
        while (result.next()) {
            Person persondetail = new Person();
            persondetail.setId(result.getLong("id"));
            persondetail.setName(result.getString("name"));
            persondetail.setEmail(result.getString("email"));
            persondetail.setDob(result.getDate("birth_date"));
            persondetail.setCreatedDate(result.getTimestamp("created_date"));
            Address personAddress = new Address();
            personAddress.setId(result.getLong("address_id"));
            persondetail.setAddress(personAddress);
            personList.add(persondetail);
        }
        readAllPerson.close();
        return personList;
    }

    public Person read (Connection con, long id, boolean includeAddress) throws SQLException, ServiceException {

        Person person  = new Person();
        readPerson =  con.prepareStatement( new StringBuilder()
                .append("SELECT id, name, email, address_id, birth_date, created_date ")
                .append("FROM person ")
                .append("WHERE id = ? ").toString());

        readPerson.setLong(1, id);
        ResultSet result = readPerson.executeQuery();
        if (result.next()) {
            person.setId(result.getLong("id"));
            person.setName(result.getString("name"));
            person.setEmail(result.getString("email"));
            person.setDob(result.getDate("birth_date"));
            Timestamp stamp = result.getTimestamp("created_date");
            person.setCreatedDate(stamp);
            if (includeAddress == true) {
                address = new AddressService();
                person.setAddress(address.read(con ,result.getInt("address_id")));
            }
            return person;
        } else { throw new ServiceException ("No person found on this Id " +id); }
    }

    public boolean update (Connection con, Person personUpdate) throws SQLException, ServiceException {

        updatePersondetail = con.prepareStatement( new StringBuilder()
                .append("UPDATE person ")
                .append("SET name = ?, email = ?, birth_date = ? ")
                .append("WHERE id = ? ").toString());

        updatePersondetail.setString(1, personUpdate.getName());
        updatePersondetail.setString(2, personUpdate.getEmail());
        updatePersondetail.setDate(3, personUpdate.getDob());
        updatePersondetail.setLong(4, personUpdate.getId());
        if(updatePersondetail.executeUpdate() > 0) { return true;}
        else { throw new ServiceException("No person found on this Id " + personUpdate.getId()); }
    }

    public boolean delete(Connection con, Person person) throws SQLException, ServiceException {


        deletePerson = con.prepareStatement( new StringBuilder()
                .append("DELETE FROM person ")
                .append(" WHERE id = ? ").toString());

        deletePerson.setLong(1, person.getId());
        if (deletePerson.executeUpdate() > 0) {
            AddressService addressService = new AddressService();
            boolean deleteAddress = addressService.delete(con, person.getAddress());
            if (deleteAddress == true) {
                return true;
            }
        } else { throw new ServiceException("Cannot delete Person"); }
        return false;
    }

//    public void log (String format, String message) {
//        System.out.format(format, message);
//    }
}

class ServiceException extends Exception{


    ServiceException(String s){
     super(s);
    }
}

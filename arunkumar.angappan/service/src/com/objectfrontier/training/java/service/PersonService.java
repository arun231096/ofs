package com.objectfrontier.training.java.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.objectfrontier.training.java.pojo.Address;
import com.objectfrontier.training.java.pojo.Person;

public class PersonService {

    AddressService address;
    public PersonService(){
        setAddress(new AddressService());
    }

    public Person create(Connection con, Person person) throws SQLException, AppException {
        validatePerson(person);
        PreparedStatement createPerson = con.prepareStatement( new StringBuilder()
                .append("INSERT INTO sr_person (first_name, last_name, email, birth_date, address_id, created_date) ")
                .append("VALUES (?, ?, ?,?,?,?) ").toString(), Statement.RETURN_GENERATED_KEYS);
        createPerson = setPerson(createPerson, person);
        person.setAddress(address.create(con, person.getAddress()));
        if (person.getAddress().getId() > 0) {
            createPerson.setLong(5, person.getAddress().getId());
            createPerson.setTimestamp(6, person.getCreatedDate());
            try {
                if (createPerson.executeUpdate() > 0) {
                    ResultSet resultSet = createPerson.getGeneratedKeys();
                    resultSet.next();
                    person.setId(resultSet.getLong(1));
                    createPerson.close();
                    return person;
                }
            } catch (SQLException e) {
//                con.rollback();
                throw new AppException(ErrorCodes.PERSON_EMAIL_DUPLICATE);
            }
        }
        throw new AppException(ErrorCodes.CREATE_ADDRESS_ERROR);
    }

    public boolean update (Connection con, Person personUpdate) throws SQLException, AppException {

        validatePerson(personUpdate);
        PreparedStatement updatePersondetail = con.prepareStatement( new StringBuilder()
                .append("UPDATE sr_person ")
                .append("SET first_name = ?, last_name = ?, email = ?, birth_date = ? ")
                .append("WHERE id = ? ").toString());
        updatePersondetail = setPerson(updatePersondetail, personUpdate);
        updatePersondetail.setLong(5, personUpdate.getId());
        try {
            if(updatePersondetail.executeUpdate() > 0) {
                return true;
                }
            else { throw new AppException(ErrorCodes.PERSON_IDENTIFICATION); }
        } catch (SQLException e) {
            throw new AppException(ErrorCodes.PERSON_EMAIL_DUPLICATE);
        }
    }

    public PreparedStatement setPerson(PreparedStatement statement, Person person) throws SQLException {
        statement.setString(1, person.getFirstname());
        statement.setString(2, person.getLastname());
        statement.setString(3, person.getEmail());
        statement.setDate(4, formatDate(person.getDob()));
        return statement;
    }

    public List<Person> readAll (Connection con) throws SQLException {

            List<Person> personList = new ArrayList<>();
            PreparedStatement readAllPerson = con.prepareStatement( new StringBuilder()
                    .append("SELECT sr_person.id, first_name, last_name, email, address_id, birth_date, created_date ")
                    .append("FROM sr_person ").toString());
            ResultSet result = readAllPerson.executeQuery();
            while (result.next()) {
                Person persondetail = new Person();
                persondetail = createPerson(result);
                Address personAddress = new Address();
                personAddress.setId(result.getLong("address_id"));
                persondetail.setAddress(personAddress);
                personList.add(persondetail);
            }
            readAllPerson.close();
            return personList;
    }

    public Person read (Connection con, long id, boolean includeAddress) throws SQLException, AppException {

        Person person  = new Person();
        PreparedStatement readPerson =  con.prepareStatement( new StringBuilder()
                .append("SELECT id, first_name, last_name, email, address_id, birth_date, created_date ")
                .append("FROM sr_person ")
                .append("WHERE id = ? ").toString());

        readPerson.setLong(1, id);
        ResultSet result = readPerson.executeQuery();
        if (result.next()) {
            person = createPerson(result);
            if (includeAddress == true) {
                address = new AddressService();
                person.setAddress(address.read(con ,result.getInt("address_id")));
            }
            return person;
        } else { throw new AppException(ErrorCodes.PERSON_IDENTIFICATION); }
    }

    public Person createPerson (ResultSet result) throws SQLException {
        Person person = new Person();
        person.setId(result.getLong("id"));
        person.setFirstname(result.getString("first_name"));
        person.setLastname(result.getString("last_name"));
        person.setEmail(result.getString("email"));
        person.setDob(formator(result.getDate("birth_date").toString()));
        Timestamp stamp = result.getTimestamp("created_date");
        person.setCreatedDate(stamp);
        return person;
    }

    public boolean delete(Connection con, Person personDelete) throws SQLException, AppException {

            PreparedStatement deletePerson = con.prepareStatement( new StringBuilder()
                    .append("DELETE FROM sr_person ")
                    .append("WHERE id = ? ").toString());
            deletePerson.setLong(1, personDelete.getId());
            if (deletePerson.executeUpdate() > 0) {
                if (address.delete(con, personDelete.getAddress())) {
                    return true;
                } else {
                    return false;
                }
            } else {throw new AppException(ErrorCodes.PERSON_IDENTIFICATION); }
    }


    private Date formatDate(String dob) throws AppException {

        try {
        Date date = Date.valueOf(formator(dob));
        return date;
        } catch (RuntimeException e) {
            throw new AppException(ErrorCodes.DATE_FORMAT_ERROR);
        }
    }
    private String formator(String dob) {

        StringBuilder dateformat = new StringBuilder();
        String[] spiltDate = dob.split("\\-");
        dateformat.append(spiltDate[2]);
        dateformat.append("-");
        dateformat.append(spiltDate[1]);
        dateformat.append("-");
        dateformat.append(spiltDate[0]);
        return dateformat.toString();
    }

    private void validatePerson(Person person) throws AppException {

        if ((person.getFirstname() != null) &&
            (person.getLastname() != null) &&
            (person.getDob() != null) &&
            (person.getEmail() != null) &&
            (person.getCreatedDate() != null)) {

            if (person.getFirstname().trim().isEmpty() ||
                person.getLastname().trim().isEmpty()  ||
                person.getDob().trim().isEmpty()       ||
                person.getEmail().trim().isEmpty()     ||
                person.getCreatedDate().toString().trim().isEmpty()) {
                throw new AppException(ErrorCodes.PERSON_FILED_EMPTY_ERROR);
            } else if (person.getFirstname().equals(person.getLastname())) {
                    throw new AppException(ErrorCodes.PERSON_DUPLICATE);
            }
        } else {
            throw new AppException(ErrorCodes.PERSON_FILED_EMPTY_ERROR);
        }
    }

    public AddressService getAddress() {
        return address;
    }

    public void setAddress(AddressService address) {
        this.address = address;
    }
//    public void log (String format, String message) {
//        System.out.format(format, message);
//    }
}


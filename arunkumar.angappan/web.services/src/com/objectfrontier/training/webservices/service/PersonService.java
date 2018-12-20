package com.objectfrontier.training.webservices.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.objectfrontier.training.webservices.pojo.Address;
import com.objectfrontier.training.webservices.pojo.Person;

public class PersonService {

    AddressService address;
    public PersonService(){
        setAddress(new AddressService());
    }

    public Person create(Connection con, Person person) throws SQLException {
        validatePerson(person);
        PreparedStatement createPerson = con.prepareStatement( Statements.INSERT_PERSON.toString(), Statement.RETURN_GENERATED_KEYS);
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
                throw new AppException(ErrorCodes.PERSON_EMAIL_DUPLICATE);
            }
        }
        throw new AppException(ErrorCodes.CREATE_ADDRESS_ERROR);
    }

    public boolean update (Connection con, Person personUpdate) throws SQLException {

        validatePerson(personUpdate);
        PreparedStatement updatePersondetail = con.prepareStatement( Statements.UPDATE_PERSON.toString());
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
        PreparedStatement readAllPerson = con.prepareStatement( Statements.READ_ALL_PERSON.toString());
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

    public Person read (Connection con, long id, boolean includeAddress) throws SQLException {

        Person person  = new Person();
        PreparedStatement readPerson =  con.prepareStatement( Statements.READ_PERSON.toString());
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

    public boolean delete(Connection con, Person personDelete) throws SQLException {

        PreparedStatement deletePerson = con.prepareStatement( Statements.DELETE_PERSON.toString());
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

    private void validatePerson(Person person) {

        List<ErrorCodes> errros = new ArrayList<>();
        if ((person.getFirstname() == null) || (person.getFirstname().trim().isEmpty())) {
            errros.add(ErrorCodes.PERSON_FILED_FIRST_ERROR);
        }
        if ((person.getLastname() == null) || (person.getLastname().trim().isEmpty())) {
            errros.add(ErrorCodes.PERSON_FILED_LAST_ERROR);
        }
        if ((person.getEmail() == null) || (person.getEmail().trim().isEmpty())) {
            errros.add(ErrorCodes.PERSON_FILED_EMAIL_ERROR);
        }
        if ((person.getDob() == null) || (person.getDob().trim().isEmpty())) {
            errros.add(ErrorCodes.PERSON_FILED_DOB_ERROR);
        }
        if ((person.getCreatedDate() == null) || (person.getCreatedDate().toString().trim().isEmpty())) {
            errros.add(ErrorCodes.PERSON_FILED_CREATED_DATE_ERROR);
        }
        if (!person.getFirstname().trim().isEmpty()) {
            if (person.getFirstname().equals(person.getLastname())) {
                errros.add(ErrorCodes.PERSON_DUPLICATE);
            }
        }
        if (errros.isEmpty() != true) {
            throw new AppException(errros);
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


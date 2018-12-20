package com.objectfrontier.training.webservices.test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.objectfrontier.training.webservices.connection.ConnectionManagement;
import com.objectfrontier.training.webservices.pojo.Address;
import com.objectfrontier.training.webservices.pojo.Person;
import com.objectfrontier.training.webservices.service.AppException;
import com.objectfrontier.training.webservices.service.ErrorCodes;

public class PersonServiceTest {

    List <Person> listOfPerson;
    List <Person> listOfExpectedPersons;
    List <Person> createdPerson;
    private static final String INPUTS_MSG = "INPUTS: Person  = %s Detail = %s.";
    private static final String ASSERT_FAIL_MSG = " expected:<%s> but was:<%s>";

    @BeforeClass
    private void init() throws SQLException, IOException {
        String url = "http://localhost:8080/ws/do/person";
        RequestHelper.setBaseUrl(url);
        Path filepath = Paths.get("res/com/objectfrontier/training/dataResource/createAll.csv");
        listOfPerson = new ReadCsv().readAllPersonData(filepath);
        filepath = Paths.get("res/com/objectfrontier/training/dataResource/expectedAll.csv");
        listOfExpectedPersons = new ReadCsv().readAllPersonData(filepath);
        createdPerson = new ArrayList<>();
    }

    @Test (dataProvider = "Create_positive", priority = 1, enabled = true)
    private void testcreate_positive(Person inputPerson , Person expectedPerson) throws SQLException {
        try {
            Person person = new RequestHelper().setMethod(HttpMethod.PUT)
                                               .setInput(inputPerson)
                                               .requestObject("?field=create", Person.class);
            createdPerson.add(person);
            Assert.assertEquals(person, expectedPerson, String.format(INPUTS_MSG, inputPerson.toString(), inputPerson.toString()));
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, inputPerson.toString(),e.getMessage()));
        }
    }

    @DataProvider (name = "Create_positive", parallel = true)
    Object[][] Create_positive() throws SQLException, IOException {
        Object[][] persons = new Object[listOfPerson.size()][2];
        for(int i = 0; i < listOfPerson.size(); i++) {
            persons[i][0] = listOfPerson.get(i);
            persons[i][1] = listOfExpectedPersons.get(i);
        }
    return persons;
    }

    @Test (dataProvider = "Create_negative", priority = 2, enabled = true)
    private void testcreate_negative(Person inputPerson, List<ErrorCodes> list) throws SQLException {
        try {
            Person person = new RequestHelper().setMethod(HttpMethod.PUT)
                                               .setInput(inputPerson)
                                               .requestObject("?field=create", Person.class);
        } catch (Exception e) {
            if (e instanceof AppException) {
                Assert.assertEquals(((AppException) e).getErrorCodes(), list, String.format(INPUTS_MSG, "hello "+list.toString(), ((AppException) e).getErrorCodes()));
            }
        }
    }

    @DataProvider (name = "Create_negative", parallel = false)
    Object[][] Create_negative() throws SQLException {
        Address address = new Address();
        address.setStreet("ramkumar street");
        address.setCity("chennai");
        address.setPostal_code(600001);
        Person person1 = new Person(0, "", "", "email@email", "23-10-2016", Timestamp.from(Instant.now()), address);
        Person person2 = new Person(0, "arun", "", "afs@ssfs", "23-10-1996", Timestamp.from(Instant.now()), address);
        Person person3 = new Person(0, "arun", "kumar", "arunak283933@gmail.com", "23-10-1996", Timestamp.from(Instant.now()), address);
        Person person4 = new Person(0, "arun", "kumar", "dssd@dsd", "", Timestamp.from(Instant.now()), address);
        Person person5 = new Person(0, "dsd", "dsddd", "ffkljk@jhdd", "23-10-1996", null, address);
        List<ErrorCodes> list = new ArrayList<>();
        List<ErrorCodes> list2 = new ArrayList<>();
        List<ErrorCodes> list3 = new ArrayList<>();
        List<ErrorCodes> list4 = new ArrayList<>();
        List<ErrorCodes> list5 = new ArrayList<>();
        list.add(ErrorCodes.PERSON_FILED_FIRST_ERROR);
        list.add(ErrorCodes.PERSON_FILED_LAST_ERROR);
        list2.add(ErrorCodes.PERSON_FILED_LAST_ERROR);
        list3.add(ErrorCodes.PERSON_EMAIL_DUPLICATE);
        list4.add(ErrorCodes.PERSON_FILED_DOB_ERROR);
        list5.add(ErrorCodes.PERSON_FILED_CREATED_DATE_ERROR);
        return new Object[][] {{person1, list}, {person2, list2}, {person3, list3}, {person4, list4}, {person5,list5}};
    }

    @Test (dataProvider = "read", priority = 3, enabled = true)
    private void testread(long id, List<ErrorCodes> list) {
        try {
            Person person = new RequestHelper().setMethod(HttpMethod.GET)
                                               .requestObject("?field=read&id=" + id, Person.class);
            Assert.assertEquals(person.getId(), id, String.format(INPUTS_MSG, id, person.toString()));
        } catch (Exception e) {
            if (e instanceof AppException) {
                Assert.assertEquals(((AppException) e).getErrorCodes(), list, String.format(INPUTS_MSG, list, ((AppException) e).getErrorCodes()));
            } else {
                Assert.fail();
            }
        }
    }

    @DataProvider (name = "read")
    Object[][] read() throws SQLException {
        List<ErrorCodes> list = new ArrayList<>();
        list.add(ErrorCodes.PERSON_IDENTIFICATION);
    return new Object[][] {{1, list}, {191, list}};
    }


    @Test (dataProvider = "readAll", priority = 4, enabled = true)
    private void testreadAll(boolean available) throws SQLException {
        try {
            List<Person> result1 = new RequestHelper().setMethod(HttpMethod.GET)
                                                      .requestObject("?field=readall", ArrayList.class);
            Assert.assertTrue(result1.isEmpty() == available);
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, "Record Not Found", "Not in record"));
        }
    }

    @DataProvider
    Object[][] readAll() throws SQLException {
        return new Object[][] {{false}};
    }

    @Test (dataProvider = "update", priority = 5, enabled = true)
    private void testupdate(Person updateperson,int i, List<ErrorCodes> list) {
        try {
            if (i % 2 == 0) {
                updateperson.setId(100);
            }
            Person person = new RequestHelper().setMethod(HttpMethod.POST)
                                               .setInput(updateperson)
                                               .requestObject("?field=update", Person.class);
            Assert.assertEquals(person, updateperson, String.format(INPUTS_MSG, updateperson.toString(), person.toString()));
        } catch (Exception e) {
            if (e instanceof AppException) {
                Assert.assertEquals(((AppException) e).getErrorCodes(), list);
            } else {
                Assert.fail();
            }
        }
    }

    @DataProvider
    Object[][] update() throws SQLException {
        List<ErrorCodes> list = new ArrayList<>();
        list.add(ErrorCodes.PERSON_IDENTIFICATION);
        Object[][] persons = new Object[createdPerson.size()][3];
        for(int i = 0; i < createdPerson.size(); i++) {
            persons[i][0] = createdPerson.get(i);
            persons[i][1] = i;
            persons[i][2] = list;
        }
    return persons;
    }

    @Test (dataProvider = "delete", priority = 6, enabled = true)
    private void testdelete(Person deletePerson, List<ErrorCodes> list) {
        try {
            Person person = new RequestHelper().setMethod(HttpMethod.POST)
                                               .setInput(deletePerson)
                                               .requestObject("?field=delete", Person.class);
            Assert.assertEquals(person, deletePerson, String.format(INPUTS_MSG, deletePerson.toString(), person.toString()));
        } catch (Exception e) {
            if (e instanceof AppException) {
                Assert.assertEquals(((AppException) e).getErrorCodes(), list);
            } else {
                Assert.fail();
            }
        }
    }

    @DataProvider
    Object[][] delete() throws SQLException {
        List<ErrorCodes> list = new ArrayList<>();
        list.add(ErrorCodes.PERSON_IDENTIFICATION);
        Object[][] persons = new Object[createdPerson.size()][2];
        for(int i = 0; i < createdPerson.size(); i++) {
            persons[i][0] = createdPerson.get(i);
            persons[i][1] = list;
        }
    return persons;
    }

    @AfterClass
    private void releaseDb() throws SQLException, IOException {
        Connection dbResource = new ConnectionManagement().getConnection();
        dbResource.setAutoCommit(false);
        dbResource.prepareStatement("DELETE FROM sr_person ").execute();
        dbResource.prepareStatement("DELETE FROM sr_address ").execute();
        dbResource.prepareStatement("ALTER TABLE sr_person AUTO_INCREMENT = 1").execute();
        dbResource.prepareStatement("ALTER TABLE sr_address AUTO_INCREMENT = 1").execute();
        dbResource.commit();
        dbResource.close();
    }
}

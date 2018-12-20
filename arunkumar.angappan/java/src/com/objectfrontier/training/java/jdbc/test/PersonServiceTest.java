package com.objectfrontier.training.java.jdbc.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.objectfrontier.training.java.jdbc.ConnectionManagement;
import com.objectfrontier.training.java.jdbc.pojo.Address;
import com.objectfrontier.training.java.jdbc.pojo.Person;
import com.objectfrontier.training.java.jdbc.service.PersonService;

@Test
public class PersonServiceTest {

    private PersonService personService;
    private Connection con;
    private static final String INPUTS_MSG = "INPUTS: Person  = %s Detail = %s.";
    private static final String ASSERT_FAIL_MSG = " expected:<%s> but was:<%s>";

    @BeforeClass
    private void init() {
        this.personService = new PersonService();
    }

    @Test (dataProvider = "Create_positive", priority = 1)
    private void testcreate_positive(Connection con, Person person) {
        try {
            Person result = personService.create(con, person);
            Assert.assertEquals(result, person, String.format(INPUTS_MSG, person.getId(), result.getAddress().getId()));
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, person.getName(), "Dupilicate Entry or Null value"));
        }
    }

    @DataProvider
    Object[][] Create_positive() throws SQLException {
        con = ConnectionManagement.getConnection();
        Person person = new Person();
        Address address = new Address();
        person.setName("arunkumar");
        person.setEmail("arunkumar.angappan@ofs.com");
        person.setDob(Date.valueOf("1996-10-23"));
        person.setCreatedDate(Timestamp.from(Instant.now()));
        address.setCity("Chennai");
        address.setPostal_code(60113);
        address.setStreet("arunnagar");
        person.setAddress(address);

        Person person4 = new Person();
        Address address4 = new Address();
        person4.setName("rajkumar");
        person4.setEmail("rajkumar.natarajan@ofs.com");
        person4.setDob(Date.valueOf("1996-08-23"));
        person4.setCreatedDate(Timestamp.from(Instant.now()));
        address4.setCity("Chennai");
        address4.setPostal_code(60113);
        address4.setStreet("arunnagar");
        person4.setAddress(address4);
        return new Object[][] { {con, person}, {con, person4} };
    }


    @Test (dataProvider = "Create_negative", priority = 2)
    private void testcreate_negative(Connection con, Person person) {
        try {
            Person result = personService.create(con, person);
            Assert.fail(String.format(ASSERT_FAIL_MSG, "Dupilicate Entry or Null value", result.getName()));
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), e.getMessage(), String.format(INPUTS_MSG, person.getName(), person.getAddress().getCity()));
        }
    }

    @DataProvider
    Object[][] Create_negative() throws SQLException {
        con = ConnectionManagement.getConnection();
        Person person3 = new Person();
        Address address3 = new Address();
        person3.setName("rajkumar");
        person3.setEmail("rajkumar.natarajan@ofs.com");
        person3.setDob(Date.valueOf("1996-08-23"));
        person3.setCreatedDate(Timestamp.from(Instant.now()));
        address3.setCity("Chennai");
        address3.setPostal_code(60113);
        address3.setStreet("arunnagar");
        person3.setAddress(address3);

        Person person2 = new Person();
        Address address2 = new Address();
        person2.setName("arunkumar");
        person2.setEmail("arunkumar.angappan@ofs.com");
        person2.setDob(Date.valueOf("1996-10-23"));
        person2.setCreatedDate(Timestamp.from(Instant.now()));
        address2.setCity("Chennai");
        address2.setPostal_code(60113);
        address2.setStreet("arunnagar");
        person2.setAddress(address2);
        return new Object[][] { {con, person3}, {con, person2} };
    }



    @Test (dataProvider = "read_positive", priority = 3)
    private void testread_positive(Connection con, long personId, boolean includeAddress, Person person) {
        try {
            Person result = personService.read(con, personId, includeAddress);
            Assert.assertEquals(result.getId(), person.getId(), String.format(INPUTS_MSG, result.getId(), result.getDob()));
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, person.getId(), "Not in record"));
        }
    }

    @DataProvider
    Object[][] read_positive() throws SQLException {
        con = ConnectionManagement.getConnection();
        Person person3 = new Person();
        Address address3 = new Address();
        person3.setId(2);
        person3.setName("rajkumar");
        person3.setEmail("rajkumar.natarajan@ofs.com");
        person3.setDob(Date.valueOf("1996-08-23"));
        person3.setCreatedDate(Timestamp.valueOf("2018-10-20 11:12:42"));
        address3.setCity("Chennai");
        address3.setPostal_code(60113);
        address3.setStreet("arunnagar");
        person3.setAddress(address3);

        Person person2 = new Person();
        person2.setId(1);
        person2.setName("arunkumar");
        person2.setEmail("arunkumar.angappan@ofs.com");
        person2.setDob(Date.valueOf("1996-10-23"));
        person2.setCreatedDate(Timestamp.valueOf("2018-10-20 11:12:42"));
        return new Object[][] { {con, 2, true, person3}, {con, 1, false, person2} };
    }

    @Test (dataProvider = "read_negative", priority = 4)
    private void testread_negative(Connection con, long personId, boolean includeAddress, String Errormessage) {
        try {
            Person result = personService.read(con, personId, includeAddress);
            Assert.fail(String.format(ASSERT_FAIL_MSG, Errormessage, "Not in record"));
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), e.getMessage(), String.format(INPUTS_MSG, "Not in record", e.getMessage()));
        }
    }

    @DataProvider
    Object[][] read_negative() throws SQLException {
        con = ConnectionManagement.getConnection();
        return new Object[][] { {con, 4, true, "Not in record"}, {con, 5, false, "Not in record"} };
    }


    @Test (dataProvider = "readAll", priority = 5)
    private void testreadAll(Connection con) {
        try {
            List <Person> result = personService.readAll(con);
            Assert.assertEquals(result, result, String.format(INPUTS_MSG, result.size(), "Not available"));
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, "Record Not Found", "Not in record"));

        }
    }

    @DataProvider
    Object[][] readAll() throws SQLException {
        con = ConnectionManagement.getConnection();
        return new Object[][] { {con}, {con} };
    }

  @Test (dataProvider = "update_positive", priority = 6)
  private void testupdate_positive(Connection con, Person person) {
      try {
          boolean result = personService.update(con, person);
          Assert.assertEquals(result, result, String.format(INPUTS_MSG, person.getId(), result));
      } catch (Exception e) {
          Assert.fail(String.format(ASSERT_FAIL_MSG, person.getName(), "Cannot Update No record found"));
      }
  }

  @DataProvider
  Object[][] update_positive() throws SQLException {
      con = ConnectionManagement.getConnection();
      Person person = new Person();
      person.setId(1);
      person.setName("arunkumar");
      person.setEmail("arunkumar.angappan@ofs.com");
      person.setDob(Date.valueOf("1996-10-23"));


      Person person4 = new Person();
      person4.setId(2);
      person4.setName("rajkumar");
      person4.setEmail("rajkumar.natarajan@ofs.com");
      person4.setDob(Date.valueOf("1996-08-23"));
      return new Object[][] { {con, person}, {con, person4} };
  }

  @Test (dataProvider = "update_negative", priority = 7)
  private void testupdate_negative(Connection con, Person person) {
      try {
          boolean result = personService.update(con, person);
          Assert.fail(String.format(ASSERT_FAIL_MSG, person.getName(), "Cannot Update No record found"));
      } catch (Exception e) {
          Assert.assertEquals(e.getMessage(), e.getMessage(), String.format(INPUTS_MSG, person.getId(), "Updated"));
      }
  }

  @DataProvider
  Object[][] update_negative() throws SQLException {
      con = ConnectionManagement.getConnection();
      Person person = new Person();
      person.setId(10);
      person.setName("arunkumar");
      person.setEmail("arunkumar.angappan@ofs.com");
      person.setDob(Date.valueOf("1996-10-23"));


      Person person4 = new Person();
      person4.setId(21);
      person4.setName("rajkumar");
      person4.setEmail("rajkumar.natarajan@ofs.com");
      person4.setDob(Date.valueOf("1996-08-23"));
      return new Object[][] { {con, person}, {con, person4} };
  }

  @Test (dataProvider = "delete_positive", priority = 8)
  private void testdelete_positive(Connection con, Person person) {
      try {
          boolean result = personService.delete(con, person);
          Assert.assertEquals(result, result, String.format(INPUTS_MSG, person.getId(), "Deleted"));
      } catch (Exception e) {
          Assert.fail(String.format(ASSERT_FAIL_MSG, person.getName(), "Cannot delete No record found"));
      }
  }

  @DataProvider
  Object[][] delete_positive() throws SQLException {
      con = ConnectionManagement.getConnection();
      Person person = new Person();
      Address address = new Address();
      address.setId(31);
      person.setId(1);
      person.setName("arunkumar");
      person.setEmail("arunkumar.angappan@ofs.com");
      person.setDob(Date.valueOf("1996-10-23"));
      person.setAddress(address);


      Person person4 = new Person();
      Address address2 = new Address();
      address2.setId(32);
      person4.setId(2);
      person4.setName("rajkumar");
      person4.setEmail("rajkumar.natarajan@ofs.com");
      person4.setDob(Date.valueOf("1996-08-23"));
      person4.setAddress(address2);
      return new Object[][] { {con, person}, {con, person4} };
  }

  @Test (dataProvider = "delete_negative", priority = 8)
  private void testdelete_negative(Connection con, Person person) {
      try {
          boolean result = personService.delete(con, person);
          Assert.fail(String.format(ASSERT_FAIL_MSG, person.getName(), "Cannot delete No record found"));
      } catch (Exception e) {
          Assert.assertEquals(e.getMessage(), e.getMessage(), String.format(INPUTS_MSG, person.getId(), "Deleted"));
      }
  }

  @DataProvider
  Object[][] delete_negative() throws SQLException {
      con = ConnectionManagement.getConnection();
      Person person = new Person();
      Address address = new Address();
      address.setId(31);
      person.setId(11);
      person.setName("arunkumar");
      person.setEmail("arunkumar.angappan@ofs.com");
      person.setDob(Date.valueOf("1996-10-23"));
      person.setAddress(address);


      Person person4 = new Person();
      Address address2 = new Address();
      address2.setId(312);
      person4.setId(12);
      person4.setName("rajkumar");
      person4.setEmail("rajkumar.natarajan@ofs.com");
      person4.setDob(Date.valueOf("1996-08-23"));
      person4.setAddress(address2);
      return new Object[][] { {con, person}, {con, person4} };
  }

}


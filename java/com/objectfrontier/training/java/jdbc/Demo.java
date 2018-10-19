package com.objectfrontier.training.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        Connection con = DriverManager.getConnection("jdbc:mysql://pc1620:3306/arunkumar_angappan", "arunkumar_angappan", "demo");
        PreparedStatement st = con.prepareStatement("select * from employee");
        System.out.println("Connected");
        ResultSet rs;
        if ((rs = st.executeQuery()) != null) {
        if (rs.next()) {
            System.out.println(rs.getInt("id") +  " " +rs.getString("name"));
        }
        }
    }

}

/*

package com.objectfrontier.training.java.jdbc.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

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
    private static final String INPUTS_MSG = "INPUTS: Person ID = %s, Address ID = %s.";
    private static final String ASSERT_FAIL_MSG = " expected:<%s> but was:<%s>";

    @BeforeClass
    private void init() {
        this.personService = new PersonService();
    }


    @Test (dataProvider = "Create_negative")
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

//    @Test (dataProvider = "Create_positive")
//    private void testcreate_positive(Connection con, Person person) {
//        try {
//            Person result = personService.create(con, person);
//            Assert.assertEquals(result, person, String.format(INPUTS_MSG, person.getId(), result.getAddress().getId()));
//        } catch (Exception e) {
//            Assert.fail(String.format(ASSERT_FAIL_MSG, person.getName(), "Dupilicate Entry or Null value"));
//        }
//    }
//
//    @DataProvider
//    Object[][] Create_positive() throws SQLException {
//        con = ConnectionManagement.getConnection();
//        Person person = new Person();
//        Address address = new Address();
//        person.setName("arunkumar");
//        person.setEmail("arunkumarangappan@ofs.com");
//        person.setDob(Date.valueOf("1996-10-23"));
//        person.setCreatedDate(Timestamp.from(Instant.now()));
//        address.setCity("Chennai");
//        address.setPostal_code(60113);
//        address.setStreet("arunnagar");
//        person.setAddress(address);
//
//        Person person4 = new Person();
//        Address address4 = new Address();
//        person4.setName("rajkumar");
//        person4.setEmail("rajkumar.natarajan@ofs.com");
//        person4.setDob(Date.valueOf("1996-08-23"));
//        person4.setCreatedDate(Timestamp.from(Instant.now()));
//        address4.setCity("Chennai");
//        address4.setPostal_code(60113);
//        address4.setStreet("arunnagar");
//        person4.setAddress(address4);
//        return new Object[][] { {con, person}, {con, person4} };
//    }


//    @Test
//    private void testcreate_negative() throws SQLException {
//        con = ConnectionManagement.getConnection();
//        Person person = new Person();
//        Address address = new Address();
////        person.setName("arunkumar");
//        person.setEmail("arunak@ofs34.com");
//        person.setDob(Date.valueOf("1996-10-23"));
//        person.setCreatedDate(Timestamp.from(Instant.now()));
//        address.setCity("Chennai");
//        address.setPostal_code(60113);
//        address.setStreet("arunnagar");
//        person.setAddress(address);
//        testcreate_negative(con, person);
//    }

//    @Test
//    private void testread_positive() throws SQLException {
//        con = ConnectionManagement.getConnection();
//        testread_positive(con, 1, true);
//    }


//    private void testread_positive(Connection con2, int i, boolean b) {
//
//        try {
//            Person result = personService.read(con, i, b);
//            Assert.assertEquals(result.getId(), i, "Success");
//        } catch (Exception e) {
//            Assert.fail(e.getMessage());
//        }
//    }
//
//    private void testcreate_negative(Connection con2, Person person) {
//
//        try {
//            Person result = personService.create(con, person);
//            Assert.assertEquals(result, null, "Success");
//        } catch (Exception e) {
//            Assert.fail(e.getMessage());
//        }
//    }
//

//    }
}



*/
package com.objectfrontier.training.java.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.objectfrontier.training.java.jdbc.ConnectionManagement;
import com.objectfrontier.training.java.jdbc.pojo.Address;
import com.objectfrontier.training.java.jdbc.service.AddressService;

public class AddressServiceTest {
    private AddressService addressService;
    private Connection con;
    private static final String INPUTS_MSG = "INPUTS: Person  = %s Detail = %s.";
    private static final String ASSERT_FAIL_MSG = " expected:<%s> but was:<%s>";

    @BeforeClass
    private void init() {
        this.addressService = new AddressService();
    }

    @Test (dataProvider = "Create_positive", priority = 1)
    private void testcreate_positive(Connection con, Address address) {
        try {
            Address result = addressService.create(con, address);
            Assert.assertEquals(result, address, String.format(INPUTS_MSG, address.getId(), result.getId()));
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, address.getCity(), "Dupilicate Entry or Null value"));
        }
    }

    @DataProvider
    Object[][] Create_positive() throws SQLException {
        con = ConnectionManagement.getConnection();
        Address address = new Address();
        address.setCity("Chennai");
        address.setPostal_code(60113);
        address.setStreet("arunnagar");

        Address address4 = new Address();
        address4.setCity("Chennai");
        address4.setPostal_code(60113);
        address4.setStreet("arunnagar");
        return new Object[][] { {con, address}, {con, address4} };
    }

    @Test (dataProvider = "Create_negative", priority = 2)
    private void testcreate_negative(Connection con, Address address) {
        try {
            Address result = addressService.create(con, address);
            Assert.fail(String.format(ASSERT_FAIL_MSG, "Null value not accepted", result.getCity()));
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), e.getMessage(), String.format(INPUTS_MSG, address.getCity(), address.getPostal_code()));
        }
    }

    @DataProvider
    Object[][] Create_negative() throws SQLException {
        con = ConnectionManagement.getConnection();
        Address address3 = new Address();
        address3.setPostal_code(60113);
        address3.setStreet("arunnagar");

        Address address2 = new Address();
        address2.setPostal_code(61210);
        address2.setStreet("arunnagar");
        return new Object[][] { {con, address3}, {con, address2} };
    }

    @Test (dataProvider = "read_positive", priority = 3)
    private void testread_positive(Connection con, long addressId, Address address) {
        try {
            Address result = addressService.read(con, addressId);
            Assert.assertEquals(result.getId(), address.getId(), String.format(INPUTS_MSG, result.getId(), result.getCity()));
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, address.getId(), "Not in record"));
        }
    }

    @DataProvider
    Object[][] read_positive() throws SQLException {
        con = ConnectionManagement.getConnection();
        Address address3 = new Address();
        address3.setId(1);
        address3.setCity("Chennai");
        address3.setPostal_code(60113);
        address3.setStreet("arunnagar");

        Address address2 = new Address();
        address2.setId(2);
        address2.setCity("Chennai");
        address2.setPostal_code(60113);
        address2.setStreet("arunnagar");

        return new Object[][] { {con, 1, address3}, {con, 2, address2} };
    }

    @Test (dataProvider = "read_negative", priority = 4)
    private void testread_negative(Connection con, long addressId, String Errormessage) {
        try {
            Address result = addressService.read(con, addressId);
            Assert.fail(String.format(ASSERT_FAIL_MSG, Errormessage, "Not in record"));
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), e.getMessage(), String.format(INPUTS_MSG, "Not in record", e.getMessage()));
        }
    }

    @DataProvider
    Object[][] read_negative() throws SQLException {
        con = ConnectionManagement.getConnection();
        return new Object[][] { {con, 24, "Not in record"}, {con, 25, "Not in record"} };
    }

    @Test (dataProvider = "readAll", priority = 5)
    private void testreadAll(Connection con) {
        try {
            List <Address> result = addressService.readAll(con);
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
    private void testupdate_positive(Connection con, Address address) {
        try {
            boolean result = addressService.update(con, address);
            Assert.assertEquals(result, result, String.format(INPUTS_MSG, address.getId(), result));
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, address.getCity(), "Cannot Update No record found"));
        }
    }

    @DataProvider
    Object[][] update_positive() throws SQLException {
        con = ConnectionManagement.getConnection();
        Address address1 = new Address();
        address1.setId(1);
        address1.setCity("Erode");
        address1.setStreet("Narayana Street");
        address1.setPostal_code(1000);


        Address address2 = new Address();
        address2.setId(2);
        address2.setCity("KPM");
        address2.setStreet("Kps Street");
        address2.setPostal_code(12121);
        return new Object[][] { {con, address1}, {con, address2} };
    }

    @Test (dataProvider = "update_negative", priority = 7)
    private void testupdate_negative(Connection con, Address address) {
        try {
            boolean result = addressService.update(con, address);
            Assert.fail(String.format(ASSERT_FAIL_MSG, address.getCity(), "Cannot Update No record found"));
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), e.getMessage(), String.format(INPUTS_MSG, address.getId(), e.getMessage()));
        }
    }

    @DataProvider
    Object[][] update_negative() throws SQLException {
        con = ConnectionManagement.getConnection();
        Address address1 = new Address();
        address1.setId(23);
        address1.setCity("Erode");
        address1.setStreet("Narayana Street");
        address1.setPostal_code(1000);

        Address address2 = new Address();
        address2.setId(23);
        address2.setCity("KPM");
        address2.setStreet("Kps Street");
        address2.setPostal_code(12121);
        return new Object[][] { {con, address1}, {con, address2} };
    }

    @Test (dataProvider = "delete_positive", priority = 8)
    private void testdelete_positive(Connection con, Address address) {
        try {
            boolean result = addressService.delete(con, address);
            Assert.assertEquals(result, result, String.format(INPUTS_MSG, address.getId(), "Deleted"));
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, address.getId(), "Cannot delete No record found"));
        }
    }

    @DataProvider
    Object[][] delete_positive() throws SQLException {
        con = ConnectionManagement.getConnection();
        Address address = new Address();
        address.setId(31);


        Address address2 = new Address();
        address2.setId(32);
        return new Object[][] { {con, address}, {con, address2} };
    }

    @Test (dataProvider = "delete_negative", priority = 8)
    private void testdelete_negative(Connection con, Address address) {
        try {
            boolean result = addressService.delete(con, address);
            Assert.fail(String.format(ASSERT_FAIL_MSG, address.getId(), "Cannot delete No record found"));
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), e.getMessage(), String.format(INPUTS_MSG, address.getId(), "Deleted"));
        }
    }

    @DataProvider
    Object[][] delete_negative() throws SQLException {
        con = ConnectionManagement.getConnection();
        Address address = new Address();
        address.setId(31);


        Address address2 = new Address();
        address2.setId(312);
        return new Object[][] { {con, address}, {con, address2} };
    }
}

package com.objectfrontier.training.webservices.test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.objectfrontier.training.webservices.connection.ConnectionManagement;
import com.objectfrontier.training.webservices.model.Address;
import com.objectfrontier.training.webservices.model.Person;
import com.objectfrontier.training.webservices.service.business.AppException;
import com.objectfrontier.training.webservices.service.business.ErrorCodes;

public class AddressServiceTest {

    RequestHelper helper;
    List <Person> listOfPersonWithAddress;
    List <Address> listOfExpectedAddress;
    List <Address> createdAddress;
    private static final String INPUTS_MSG = "INPUTS: Address  = %s Detail = %s.";
    private static final String ASSERT_FAIL_MSG = " expected:<%s> but was:<%s>";

    @BeforeClass
    private void init() throws SQLException, IOException {
        helper = new RequestHelper();
        String url = "http://localhost:8080/ws/do/address";
        RequestHelper.setBaseUrl(url);
        Path filepath = Paths.get("res/com/objectfrontier/training/dataResource/createAll.csv");
        listOfPersonWithAddress = new ReadCsv().readAllPersonData(filepath);
        filepath = Paths.get("res/com/objectfrontier/training/dataResource/expectedAll.csv");
//        listOfExpectedPersons = new ReadCsv().readAllPersonData(filepath);
        createdAddress = new ArrayList<>();
    }

    @DataProvider (parallel = false)
    Object[][] Create_positive() throws SQLException {

        Object[][] address = new Object[listOfPersonWithAddress.size()][2];
        for(int i = 0; i < listOfPersonWithAddress.size(); i++) {
            address[i][0] = listOfPersonWithAddress.get(i).getAddress();
            address[i][1] = listOfPersonWithAddress.get(i).getAddress();
        }
    return address;
    }

    @Test (dataProvider = "Create_positive", priority = 1, enabled = true)
    private void testcreate_positive(Address address, Address expectedAddress) {
        try {
            Address result = new RequestHelper().setSecured(false)
                                   .setMethod(HttpMethod.PUT)
                                   .setInput(address)
                                   .requestObject("?field=create", Address.class);
            createdAddress.add(result);
            Assert.assertTrue(result.getId()>0);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @DataProvider
    Object[][] Create_negative() throws SQLException {

        Address address = new Address();
        address.setCity("");
        address.setStreet("Hello street");
        address.setPostal_code(638183);
        Address address2 = new Address();
        address2.setCity("Hello City");
        address2.setStreet("");
        address2.setPostal_code(638183);
        Address address3 = new Address();
        address3.setCity("Hello City");
        address3.setStreet("Hello Street");
        List<ErrorCodes> list = new ArrayList<>();
        List<ErrorCodes> list2 = new ArrayList<>();
        List<ErrorCodes> list3 = new ArrayList<>();
        list.add(ErrorCodes.ADDRESS_FILED_EMPTY_CITY);
        list2.add(ErrorCodes.ADDRESS_FILED_EMPTY_STREET);
        list3.add( ErrorCodes.ADDRESS_FILED_EMPTY_POSTAL_CODE);
    return new Object[][] {{address, list},
                           {address2, list2},
                           {address3, list3}};
    }

    @Test (dataProvider = "Create_negative", priority = 2, enabled = true)
    private void testcreate_negative(Address address, List<ErrorCodes> errors) {
        try {
            helper = new RequestHelper();
            Address result = new RequestHelper().setMethod(HttpMethod.PUT)
                                   .setInput(address)
                                   .requestObject("?field=create", Address.class);
            Assert.fail();
        } catch (Exception e) {
            if (e instanceof AppException) {
                Assert.assertEquals(((AppException) e).getErrorCodes(), errors, String.format(INPUTS_MSG, address.getCity(), address.getPostal_code()));
            }
        }
    }

    @DataProvider
    Object[][] readAll() throws SQLException {
        return new Object[][] { {false} };
    }

    @Test (dataProvider = "readAll", priority = 3, enabled = true)
    private void testreadAll(boolean status) {
        try {
            helper = new RequestHelper();
            List <Address> result = helper.setSecured(true)
                                          .setMethod(HttpMethod.GET)
                                          .requestObject("?field=readall", ArrayList.class);
            Assert.assertTrue((result.isEmpty() == status));
        } catch (Exception e) {
                Assert.fail();
        }
    }

    @DataProvider
    Object[][] read() throws SQLException {
        List<ErrorCodes> list = new ArrayList<>();
        list.add(ErrorCodes.ADDRESS_IDENTITFICATION_ERROR);
        return new Object[][] { {10, list}, {121, list} };
    }

    @Test (dataProvider = "read", priority = 4, enabled = true)
    private void testread(long addressId, List<ErrorCodes> list) {
        try {
            helper = new RequestHelper();
            Address result = new RequestHelper().setSecured(false)
                                    .setMethod(HttpMethod.GET)
                                    .requestObject("?field=read&id=" + addressId, Address.class);
            Assert.assertEquals(addressId, result.getId());
        } catch (Exception e) {
            if (e instanceof AppException) {
                System.out.println(((AppException) e).getErrorCodes());
                Assert.assertEquals(((AppException) e).getErrorCodes(), list);
            } else {
                Assert.fail();
            }
        }
    }


    @DataProvider
    Object[][] Update() throws SQLException {

        List<ErrorCodes> list = new ArrayList<>();
        list.add(ErrorCodes.ADDRESS_IDENTITFICATION_ERROR);
        Object[][] address = new Object[createdAddress.size()][3];
        for(int i = 0; i < createdAddress.size(); i++) {
            address[i][0] = createdAddress.get(i);
            createdAddress.get(i).setCity("Chennai");
            address[i][1] = i;
            address[i][2] = list;
        }
    return address;
    }

    @Test (dataProvider = "Update", priority = 5, enabled = true)
    private void testupdate(Address address, int i, List<ErrorCodes> list) {
        try {
            helper = new RequestHelper();
            if (i%2 == 0) {
                address.setId(100);
            }
            Address result = new RequestHelper().setSecured(true)
                                   .setMethod(HttpMethod.POST)
                                   .setInput(address)
                                   .requestObject("?field=update", Address.class);
            Assert.assertEquals(result, address, String.format(INPUTS_MSG, address.getCity(), address.getPostal_code()));
        } catch (Exception e) {
            if (e instanceof AppException) {
                System.out.println(((AppException) e).getErrorCodes());
                Assert.assertEquals(((AppException) e).getErrorCodes(), list);
            } else {
                Assert.fail();
            }
        }
    }

    @DataProvider
    Object[][] Delete() throws SQLException {

        List<ErrorCodes> list = new ArrayList<>();
        list.add(ErrorCodes.ADDRESS_IDENTITFICATION_ERROR);
        Object[][] address = new Object[createdAddress.size()][2];
        for(int i = 0; i < createdAddress.size(); i++) {
            address[i][0] = createdAddress.get(i);
            address[i][1] = list;
        }
    return address;
    }

    @Test (dataProvider = "Delete", priority = 6, enabled = true)
    private void testdelete(Address address, List<ErrorCodes> list) {
        try {
            Address result = new RequestHelper().setSecured(true)
                                   .setMethod(HttpMethod.POST)
                                   .setInput(address)
                                   .requestObject("?field=delete", Address.class);
            Assert.assertEquals(result, address, String.format(INPUTS_MSG, address.getCity(), address.getPostal_code()));
        } catch (Exception e) {
            if (e instanceof AppException) {
                System.out.println(((AppException) e).getErrorCodes());
                Assert.assertEquals(((AppException) e).getErrorCodes(), list);
            } else {
                Assert.fail();
            }
        }
    }

    @AfterClass
    private void releaseDb() throws SQLException, IOException {
        Connection dbResource = new ConnectionManagement().getConnection();
        dbResource.setAutoCommit(false);
//        dbResource.prepareStatement("DELETE FROM sr_person ").execute();
        dbResource.prepareStatement("DELETE FROM sr_address ").execute();
//        dbResource.prepareStatement("ALTER TABLE sr_person AUTO_INCREMENT = 1").execute();
        dbResource.prepareStatement("ALTER TABLE sr_address AUTO_INCREMENT = 1").execute();
        dbResource.commit();
        dbResource.close();
    }
}

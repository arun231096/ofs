package com.objectfrontier.training.webservices.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.objectfrontier.training.webservices.model.Address;
import com.objectfrontier.training.webservices.service.business.AppException;
import com.objectfrontier.training.webservices.service.business.ErrorCodes;

public class TestAddressServlet extends TestBaseServlet {

    private static RequestHelper helper;
    List<Address> clist = new ArrayList<>();

    @BeforeClass
    private void authenticate() {
        helper = super.login();
    }

    @Test(dataProvider = "dpCreate", priority = 1, enabled = true)
    public void testCreate(Address input, AppException expectedError) {

        try {

            Address result = helper.setSecured(true)
                                   .setMethod(HttpMethod.PUT)
                                   .setInput(input)
                                   .requestObject("/do/address?field=create", Address.class);
            System.out.println(result.toString());
            Assert.assertEquals(result, input);
            clist.add(result);
//            Assert.assertEquals(JsonConverter.toJson(result), JsonConverter.toJson(input));
        } catch (Exception e) {
//            System.out.println(e.getMessage());
            if(e instanceof AppException) {
                Assert.assertEquals(((AppException) e).getErrorCodes(), expectedError.getErrorCodes());
            } else {
                Assert.fail();
            }
        }
    }

    @DataProvider
    public Object[][] dpCreate() {
        return new Object[][] {
            new Object[] { new Address(2, "OMR",  null, 600013), new AppException(ErrorCodes.ADDRESS_FILED_EMPTY_CITY) },
            new Object[] { new Address(3, "ECR", "Chennai", 600013), new AppException(ErrorCodes.CREATE_ADDRESS_ERROR) },
            new Object[] { new Address(4, "CSIR", "Chennai", 600013), new AppException(ErrorCodes.CREATE_ADDRESS_ERROR) }
        };
    }

    @DataProvider
    Object[][] Update() throws SQLException {

        return new Object[][] {
            new Object[] { new Address(2, "OMR",  null, 600013), new AppException(ErrorCodes.ADDRESS_FILED_EMPTY_CITY) },
            new Object[] { new Address(11, "EcR", "Chennai", 600013), new AppException(ErrorCodes.CREATE_ADDRESS_ERROR) },
            new Object[] { new Address(14, "CsIR", "Chennai", 600013), new AppException(ErrorCodes.CREATE_ADDRESS_ERROR) }
        };
    }

    @Test (dataProvider = "Update", priority = 2, enabled = true)
    private void testupdate(Address address, AppException expectedError) {
        try {
            Address result = helper.setSecured(true)
                                   .setMethod(HttpMethod.POST)
                                   .setInput(address)
                    .requestObject("/do/address?field=update", Address.class);
            System.out.println(result.toString());
            Assert.assertEquals(result, address);
        } catch (Exception e) {
            if (e instanceof AppException) {
                System.out.println(((AppException) e).getErrorCodes());
                Assert.assertEquals(((AppException) e).getErrorCodes(), expectedError.getErrorCodes());
            } else {
                Assert.fail();
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
            List <Address> result = helper.setSecured(true)
                                          .setMethod(HttpMethod.GET)
                                          .setInput(null)
                                          .requestObject("/do/address?field=readall", ArrayList.class);
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
            Address result = helper.setSecured(true)
                                   .setMethod(HttpMethod.GET)
                                   .setInput(null)
                                   .requestObject("/do/address?field=read&id=" + addressId, Address.class);
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
    Object[][] Delete() throws SQLException {

        List<ErrorCodes> list = new ArrayList<>();
        list.add(ErrorCodes.ADDRESS_IDENTITFICATION_ERROR);
        Object[][] address = new Object[clist.size()][3];
        for(int i = 0; i < clist.size(); i++) {
            address[i][0] = clist.get(i);
            address[i][1] = list;
            address[i][2] = i;
        }
    return address;
    }

    @Test (dataProvider = "Delete", priority = 5, enabled = true)
    private void testdelete(Address address, List<ErrorCodes> list, int i) {
        try {
            if(i == 2) {
                address.setId(250);
            }
            Address result = helper.setSecured(true)
                                   .setMethod(HttpMethod.POST)
                                   .setInput(address)
                                   .requestObject("/do/address?field=delete", Address.class);
            Assert.assertEquals(result, address);
        } catch (Exception e) {
            if (e instanceof AppException) {
                System.out.println(((AppException) e).getErrorCodes());
                Assert.assertEquals(((AppException) e).getErrorCodes(), list);
            } else {
                Assert.fail();
            }
        }
    }

//    @DataProvider
//    Object[][] read() throws SQLException {
//        List<ErrorCodes> list = new ArrayList<>();
//        list.add(ErrorCodes.ADDRESS_IDENTITFICATION_ERROR);
//        return new Object[][] { {10, list}, {121, list} };
//    }
}

package com.objectfrontier.training.webservices.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.objectfrontier.training.webservices.model.Person;
import com.objectfrontier.training.webservices.service.business.AppException;
import com.objectfrontier.training.webservices.service.business.ErrorCodes;

public class DemoTest {

    @BeforeClass
    private void init() throws SQLException, IOException {
        String url = "http://localhost:8080/ws/do/person";
        RequestHelper.setBaseUrl(url);
    }

    @Test (dataProvider = "Create_positive", priority = 1, enabled = true)
    private void testcreate_positive(Person inputPerson , List<ErrorCodes> list) throws SQLException {
        try {
            boolean person = new RequestHelper().setMethod(HttpMethod.PUT)
                                               .setInput(inputPerson)
                                               .requestObject("/authenticate", boolean.class);
            Assert.assertEquals(person, true);
        } catch (Exception e) {
            if( e instanceof AppException) {
                Assert.assertEquals(((AppException) e).getErrorCodes(), list);
            } else {
                Assert.fail();
            }
        }
    }

    @DataProvider (name = "Create_positive", parallel = true)
    Object[][] Create_positive() throws SQLException, IOException {
       Person person = new Person();
       person.setEmail("arunak283933@gmail.com");
       person.setPassword("123456");
       List<ErrorCodes> list = new ArrayList<>();
       list.add(ErrorCodes.LOGIN_INVALIDATE);
       return new Object[][] {{person, list}};
    }
}

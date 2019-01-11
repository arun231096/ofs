package com.objectfrontier.training.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.time.Instant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.objectfrontier.training.spring_view.model.Address;
import com.objectfrontier.training.spring_view.model.Person;
import com.objectfrontier.training.spring_view.service.AddressService;
import com.objectfrontier.training.spring_view.service.PersonService;
import com.objectfrontier.training.spring_view.utilities.AppException;
import com.objectfrontier.training.spring_view.utilities.ConnectionManagement;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @InjectMocks
    PersonService mockDemoClass;
    @Mock
    Address address;
    @Mock
    Person person;
    @Mock
    AddressService addressService;
    @Mock
    ConnectionManagement manager;
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    Connection con;
    java.sql.Timestamp stamp;
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        stamp = java.sql.Timestamp.from(Instant.now());
        address = new Address("cc", "dfdf", 34934839);
        person = new Person("arun", "kumar", "arun@sasurieinfo.tech", "12345", true, "23-10-1996", stamp, address);
        con = manager.getCon();
    }
    @Test
    public void createTest() throws Exception {

        mockDemoClass = mock(PersonService.class);
        when(mockDemoClass.create(con, person)).thenReturn(person);
        Person expected = mockDemoClass.create(null, person);
        verify(mockDemoClass).create(con, person);
        Assert.assertEquals(person, expected);
    }

    @Test(expected = AppException.class)
    public void createTestNegative() throws Exception {

        mockDemoClass = mock(PersonService.class);
        thrown.expect(AppException.class);
        Person expected = mockDemoClass.create(null, person);
        verify(mockDemoClass).create(con, person);
        Assert.assertEquals(person, expected);
    }

    @Test
    public void readTest() throws Exception {

        PersonService mockDemoClass = mock(PersonService.class);
        when(mockDemoClass.read(con, 1, true)).thenReturn(person);
        Person expected = mockDemoClass.read(con, 1, true);
        Person actual = person;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void updateTest() throws Exception {

        mockDemoClass = mock(PersonService.class);
        when(mockDemoClass.update(null, person)).thenReturn(false);
        boolean expected = mockDemoClass.update(con, person);
        Assert.assertEquals(false, expected);
    }

    @Test
    public void deleteTest() throws Exception {

        PersonService mockDemoClass = mock(PersonService.class);
        when(mockDemoClass.delete(null, person)).thenReturn(false);
        boolean expected = mockDemoClass.delete(con, person);
        Assert.assertEquals(false, expected);
    }
}
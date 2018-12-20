package com.objectfrontier.training.webservices.test;

import org.testng.annotations.Test;

@Test
public class Demo {

//    private PersonService personService;
//    private Connection con;
//
//    @BeforeClass
//    private void init() {
//        this.personService = new PersonService();
//    }
//
//    @Test
//    private void testcreate_positive() throws SQLException {
//        con = ConnectionManagement.getConnection();
//        Person person = new Person();
//        Address address = new Address();
//        person.setId(10);
//        person.setName("arunkumar");
//        person.setEmail("arunak@ofs.com");
//        person.setDob(Date.valueOf("1996-10-23"));
//        person.setCreatedDate(Timestamp.from(Instant.now()));
//        address.setCity("Chennai");
//        address.setPostal_code(60113);
//        address.setStreet("arunnagar");
//        address.setId(10);
//        person.setAddress(address);
//        testcreate_positive(con, person, person);
//    }
//
//    private void testcreate_positive(Connection con, Person person, Person person1) {
//
//        try {
//            Person result = personService.create(con, person);
//            Assert.assertEquals(result, person1, "Success");
//        } catch (Exception e) {
//            Assert.fail(e.getMessage());
//        }
//    }
}

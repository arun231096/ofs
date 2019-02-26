package com.objectfrontier.training.webservices.test;

public class DemoTest {

//    private PersonService personService;
////    private Connection con;
////    private Connection dbResource;
//    List <Person> listOfPerson;
//    List <Person> listOfExpectedPersons;
//    List <Person> createdPerson;
//    private static final String INPUTS_MSG = "INPUTS: Person  = %s Detail = %s.";
//    private static final String ASSERT_FAIL_MSG = " expected:<%s> but was:<%s>";
////    HikariDataSource ds;
////
////    {
////        ds = new ConnectionManagement().hikariConnection();
////    }
//
//    @BeforeClass
//    private void init() throws SQLException, IOException {
////        con = ConnectionManagement.getConnection();
////        dbResource = new ConnectionManagement().getConnection();
//        this.personService = new PersonService();
//        Path filepath = Paths.get("res/com/objectfrontier/training/dataResource/createAll.csv");
//        listOfPerson = readAllPersonData(filepath);
//        filepath = Paths.get("res/com/objectfrontier/training/dataResource/expectedAll.csv");
//        listOfExpectedPersons = readAllPersonData(filepath);
//        createdPerson = new ArrayList<>();
//    }
//
//    private List<Person> readAllPersonData(Path filepath) throws IOException {
//        // TODO Auto-generated method stub
//        List<Person> ListOfpersonData = new ArrayList<>();
//        List<String> listOfPerson = Files.readAllLines(filepath);
//        for (String personData : listOfPerson) {
//            String personDetails[] =personData.split("\\,");
//            Person person = new Person();
//            Address address = new Address();
//            person.setFirstname(personDetails[0]);
//            person.setLastname(personDetails[1]);
//            person.setEmail(personDetails[2]);
//            person.setDob(personDetails[3]);
//            person.setCreatedDate(Timestamp.from(Instant.now()));
//            address.setStreet(personDetails[4]);
//            address.setCity(personDetails[5]);
//            address.setPostal_code(Integer.parseInt(personDetails[6]));
//            if (personDetails.length > 7) {
//                person.setId(Integer.parseInt(personDetails[7]));
//                address.setId(Integer.parseInt(personDetails[8]));
//            }
//            person.setAddress(address);
//            ListOfpersonData.add(person);
//        }
//        return ListOfpersonData;
//    }
//
//    @Test (dataProvider = "Create_positive", priority = 1)
//    private void testcreate_positive(Person inputPerson , Person expectedPerson) throws SQLException {
//        Connection dbResource = null;
//        try {
//            System.out.println(System.currentTimeMillis());
//            dbResource = new ConnectionManagement().getHikariConnection();
//            System.out.println(dbResource);
//            dbResource.setAutoCommit(false);
//            Person person = personService.create(dbResource,inputPerson);
//            createdPerson.add(person);
//            Assert.assertEquals(person, expectedPerson, String.format(INPUTS_MSG, inputPerson.toString(), inputPerson.toString()));
//            dbResource.commit();
//            dbResource.close();
//        } catch (Exception e) {
//            dbResource.rollback();
//            Assert.fail(String.format(ASSERT_FAIL_MSG, inputPerson.toString(),e.getMessage()));
//        }
//    }
//
//    @DataProvider (name = "Create_positive", parallel = true)
//    Object[][] Create_positive() throws SQLException, IOException {
//        Object[][] persons = new Object[listOfPerson.size()][2];
//        for(int i = 0; i < listOfPerson.size(); i++) {
//            persons[i][0] = listOfPerson.get(i);
//            persons[i][1] = listOfExpectedPersons.get(i);
//        }
//    return persons;
//    }
//
//    @Test (dataProvider = "Create_negative", priority = 2)
//    private void testcreate_negative(Person inputPerson) throws SQLException {
//        Connection dbResource = null;
//        try {
//            dbResource = ds.getConnection();
//            dbResource.setAutoCommit(false);
//            Person person = personService.create(dbResource, inputPerson);
//            Assert.fail(String.format(ASSERT_FAIL_MSG, ErrorCodes.PERSON_EMAIL_DUPLICATE, person));
//            dbResource.rollback();
//            dbResource.commit();
//            dbResource.close();
//        } catch (Exception e) {
//            dbResource.commit();
//            dbResource.close();
//            Assert.assertEquals(e, e, String.format(INPUTS_MSG, "hello "+inputPerson.toString(), e.toString()));
//        }
//    }
//
//    @DataProvider (name = "Create_negative", parallel = true)
//    Object[][] Create_negative() throws SQLException {
//        Person person1 = new Person();
//        person1.setFirstname("first");
//        person1.setLastname("second");
//        person1.setEmail("arunak283933@gmail.com");
//        person1.setDob("23-10-1996");
//        person1.setCreatedDate(Timestamp.from(Instant.now()));
//        Person person2 = new Person();
//        person2.setFirstname("first");
//        person2.setLastname("first");
//        person2.setEmail("arunak28ee3933@gmail.com");
//        person2.setCreatedDate(Timestamp.from(Instant.now()));
//        return new Object[][] {{person1}, {person2}};
//    }
//
//    @Test (dataProvider = "read_positive", priority = 3)
//    private void testread_positive(Person person) {
//        Connection dbResource = null;
//        try {
//            dbResource = ds.getConnection();
//            dbResource.setAutoCommit(false);
//            Person result = personService.read(dbResource, person.getId(), true);
//            Assert.assertEquals(result, result, String.format(INPUTS_MSG, person.toString(), result.toString()));
//            dbResource.close();
//        } catch (Exception e) {
//            Assert.fail(String.format(ASSERT_FAIL_MSG, person.toString(), ErrorCodes.PERSON_IDENTIFICATION));
//        }
//    }
//
//    @DataProvider (name = "read_positive")
//    Object[][] read_positive() throws SQLException {
//        Object[][] persons = new Object[listOfExpectedPersons.size()][1];
//        for(int i = 0; i < listOfExpectedPersons.size(); i++) {
//            persons[i][0] = listOfExpectedPersons.get(i);
//        }
//    return persons;
//    }
//
//
//    @Test (dataProvider = "read_negative", priority = 4)
//    private void testread_negative(Person person) throws SQLException {
//        Connection dbResource = null;
//        try {
//            dbResource = ds.getConnection();
//            dbResource.setAutoCommit(false);
//            personService.read(dbResource, person.getId()+100, true);
//            Assert.fail(String.format(ASSERT_FAIL_MSG, person.toString(), ErrorCodes.PERSON_IDENTIFICATION));
//            dbResource.close();
//        } catch (Exception e) {
//            dbResource.close();
//            Assert.assertEquals(e, e, String.format(INPUTS_MSG, person.toString(), e.toString()));
//        }
//    }
//
//    @DataProvider
//    Object[][] read_negative() throws SQLException {
//        Object[][] persons = new Object[listOfExpectedPersons.size()][1];
//        for(int i = 0; i < listOfExpectedPersons.size(); i++) {
//            persons[i][0] = listOfExpectedPersons.get(i);
//        }
//        return persons;
//    }
//    @Test (dataProvider = "readAll", priority = 5)
//    private void testreadAll(Connection dbResource) throws SQLException {
//        try {
//            createdPerson = personService.readAll(dbResource);
//            Assert.assertEquals(createdPerson, createdPerson, String.format(INPUTS_MSG, createdPerson.size(), "Not available"));
//            dbResource.close();
//        } catch (Exception e) {
//            dbResource.close();
//            Assert.fail(String.format(ASSERT_FAIL_MSG, "Record Not Found", "Not in record"));
//        }
//    }
//
//    @DataProvider
//    Object[][] readAll() throws SQLException {
//        Connection dbResource = ds.getConnection();
//        dbResource.setAutoCommit(false);
//        return new Object[][] { {dbResource} };
//    }
//
//    @Test (dataProvider = "update_positive", priority = 6)
//    private void testupdate_positive(Person updateperson, boolean expectedResult) {
//        Connection dbResource = null;
//        try {
//            dbResource = ds.getConnection();
//            dbResource.setAutoCommit(false);
//            boolean result = personService.update(dbResource, updateperson);
//            Assert.assertEquals(result, expectedResult, String.format(INPUTS_MSG, updateperson.toString(), result));
//            dbResource.commit();
//            dbResource.close();
//        } catch (Exception e) {
//            Assert.fail(String.format(ASSERT_FAIL_MSG, updateperson.toString(), ErrorCodes.PERSON_IDENTIFICATION));
//        }
//    }
//
//    @DataProvider
//    Object[][] update_positive() throws SQLException {
//        Object[][] persons = new Object[createdPerson.size()][2];
//        for(int i = 0; i < createdPerson.size(); i++) {
//            persons[i][0] = createdPerson.get(i);
//            persons[i][1] = true;
//        }
//    return persons;
//    }
//
//    @Test (dataProvider = "update_negative", priority = 7)
//    private void testupdate_negative(Person updateperson) throws SQLException {
//        Connection dbResource = null;
//        try {
//            dbResource = ds.getConnection();
//            dbResource.setAutoCommit(false);
//            updateperson.setId(1000);
//            personService.update(dbResource, updateperson);
//            Assert.fail(String.format(ASSERT_FAIL_MSG, updateperson.toString(), ErrorCodes.PERSON_IDENTIFICATION));
//            dbResource.close();
//        } catch (Exception e) {
//            dbResource.close();
//            Assert.assertEquals(e.getMessage(), e.getMessage(), String.format(INPUTS_MSG, updateperson.toString(), "Updated"));
//        }
//    }
//
//    @DataProvider
//    Object[][] update_negative() throws SQLException {
//        Person person = new Person();
//        person.setFirstname("first");
//        person.setLastname("last");
//        person.setEmail("arunak28ee3933@gmail.com");
//        return new Object[][] {{person}};
//    }
//
//    @Test (dataProvider = "delete_positive", priority = 8)
//    private void testdelete_positive(Person expectedPerson) {
//        Connection dbResource = null;
//        try {
//            dbResource = ds.getConnection();
//            dbResource.setAutoCommit(false);
//            boolean result = personService.delete(dbResource, expectedPerson);
//            dbResource.commit();
//            dbResource.close();
//            Assert.assertEquals(result, true, String.format(INPUTS_MSG, expectedPerson.toString(), "Deleted"));
//        } catch (Exception e) {
//            Assert.fail(String.format(ASSERT_FAIL_MSG, expectedPerson.toString(),e.getMessage()));
//        }
//    }
//
//    @DataProvider
//    Object[][] delete_positive() throws SQLException {
//        Object[][] persons = new Object[createdPerson.size()][1];
//        for(int i = 0; i < createdPerson.size(); i++) {
//            persons[i][0] = createdPerson.get(i);
//        }
//    return persons;
//    }
//    @Test (dataProvider = "delete_negative", priority = 9)
//    private void testdelete_negative(Person expectedPerson) throws SQLException {
//        Connection dbResource = null;
//        try {
//            dbResource = ds.getConnection();
//            dbResource.setAutoCommit(false);
//            personService.delete(dbResource, expectedPerson);
//            Assert.fail(String.format(ASSERT_FAIL_MSG, expectedPerson.toString(),ErrorCodes.ADDRESS_IDENTITFICATION_ERROR));
//        } catch (Exception e) {
//            dbResource.close();
//            Assert.assertEquals(e.getMessage(), e.getMessage(), String.format(INPUTS_MSG, expectedPerson.toString(), "Deleted"));
//        }
//    }
//
//    @DataProvider
//    Object[][] delete_negative() throws SQLException {
//        Object[][] persons = new Object[createdPerson.size()][1];
//        for(int i = 0; i < createdPerson.size(); i++) {
//            persons[i][0] = createdPerson.get(i);
//        }
//    return persons;
//    }
//
//    @AfterClass
//    private void releaseDb() throws SQLException, IOException {
//        Connection dbResource = ds.getConnection();
//        dbResource.setAutoCommit(false);
//        dbResource.prepareStatement("DELETE FROM sr_person ").execute();
//        dbResource.prepareStatement("DELETE FROM sr_address ").execute();
//        dbResource.prepareStatement("ALTER TABLE sr_person AUTO_INCREMENT = 1").execute();
//        dbResource.prepareStatement("ALTER TABLE sr_address AUTO_INCREMENT = 1").execute();
//        dbResource.commit();
//        dbResource.close();
//    }
}

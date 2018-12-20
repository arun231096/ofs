package com.objectfrontier.training.webservices.test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.objectfrontier.training.webservices.model.Address;
import com.objectfrontier.training.webservices.model.Person;
import com.objectfrontier.training.webservices.service.business.AppException;

public class HttpClientDemo {

    private void run(String[] args) throws Exception {

        String url = "http://localhost:8080/ws/do/person";
        RequestHelper.setBaseUrl(url);
        Address input = new Address();
        input.setId(1033);
        input.setStreet("ramkumar street");
        input.setCity("chennai");
        input.setPostal_code(600001);
        Person person = new Person();
        person.setId(22);
        person.setFirstname("Arun");
        person.setLastname("kumar");
        person.setEmail("arunkumarak@12ak2232");
        person.setDob("23-10-1996");
        person.setCreatedDate(Timestamp.from(Instant.now()));
        person.setAddress(input);
        RequestHelper helper = new RequestHelper();
        try {
//            Person result = helper.setSecured(false)
//                    .setMethod(HttpMethod.GET)
////                    .setInput(input)
//                    .requestObject("/read?id="+1, Person.class);
//            log(result);
            Person person1 = new RequestHelper().setMethod(HttpMethod.PUT)
                  .setInput(person)
                  .requestObject("?field=create", Person.class);
            Person person2 = new RequestHelper().setMethod(HttpMethod.POST)
                    .setInput(person1)
                    .requestObject("?field=update", Person.class);
            log(person2);
            Person person3 = new RequestHelper().setMethod(HttpMethod.POST)
                    .setInput(person2)
                    .requestObject("?field=delete", Person.class);
            log(person3);
            Person result = new RequestHelper().setMethod(HttpMethod.GET)
//                                               .setInput(person)
                                               .requestObject("?field=read&id=1", Person.class);
            log(result);
            List<Person> result1 = new RequestHelper().setMethod(HttpMethod.GET)
//                  .setInput(person)
                  .requestObject("?field=readall", ArrayList.class);
            log(result1);
        } catch (AppException e) {
//            if (e instanceof AppException) {
//                System.out.println(JsonConverter.toObject(e.toString(), AppException.class).getErrorCodes().get(0).getErrorMeggage());
                System.out.println(e.getErrorCodes());
//            }
        }
    }

    public static void main(String[] args) {
        try {
            new HttpClientDemo().run(args);
        } catch (Exception e) {
            log(e);
        }
    }

    private static void log(Object o) {
        if (o instanceof Throwable) {
            ((Throwable)o).printStackTrace(System.err);
        } else {
            System.out.println(o.toString());
        }
    }
}

package com.ofs.training.Hibernate.Service;

import java.util.List;

import org.hibernate.Session;

import com.ofs.training.Hibernate.Model.Person;

public class PersonService {

    public Person create(Person person, Session session) {

        session.beginTransaction();
        session.save(person);
        return person;
    }

    public Person read(Session session, int readId) {

        session.beginTransaction();
        Person person = session.get(Person.class, readId);
        return person;
    }

    public List readAll(Session session) {

        session.beginTransaction();
        List person = session.createQuery("from person_ui").list();
        return person;
    }

    public void update(Session session) {

        session.beginTransaction();
        Person person = session.get(Person.class, 1);
        person.setLastname("karthick");
    }

}

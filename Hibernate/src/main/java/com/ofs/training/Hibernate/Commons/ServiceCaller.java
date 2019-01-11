package com.ofs.training.Hibernate.Commons;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ofs.training.Hibernate.Model.Person;
import com.ofs.training.Hibernate.Service.PersonService;

public class ServiceCaller {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        Person person = new Person("arun", "kumar", "arunak2833933@gmail.com", "1996-10-23", true);
        PersonService demoApp = new PersonService();
        int readId = 1;
        System.out.println(demoApp.read(session, readId));
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    public static void log(String format, Object value) {
        System.out.format(format, value);
    }

}

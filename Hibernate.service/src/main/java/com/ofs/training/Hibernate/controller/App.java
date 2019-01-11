package com.ofs.training.Hibernate.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ofs.training.Hibernate.model.Person;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Person.class)
                                 .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {

            // create Object Entity
            Person person = new Person("arun", "arunak283933@gmail.com");
            //begin tranc
            session.beginTransaction();
            //save person
            session.save(person);
            //commit tranc
            session.getTransaction().commit();
            System.out.println("Row Added");

        } finally {
            session.close();
            factory.close();
        }
    }

}

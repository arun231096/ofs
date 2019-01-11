package com.ofs.training.Hibernate.Servlets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofs.training.Hibernate.Model.Person;
import com.ofs.training.Hibernate.Service.PersonService;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/person", produces = "application/json")
    public void getPerson() {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        System.out.println(personService.read(session, 1));
        session.close();
        factory.close();
    }
}

package com.objectfrontier.training.spring_view.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.objectfrontier.training.spring_view.model.Person;
import com.objectfrontier.training.spring_view.service.PersonService;
import com.objectfrontier.training.spring_view.utilities.ConnectionManagement;




@Controller
public class AppController {

    @Autowired
    PersonService personService;

    @GetMapping("/person")
    public String readAll(ModelMap model) throws SQLException {

        ConnectionManagement.init();
        Connection connection = ConnectionManagement.getCon();
        List<Person> personList = personService.readAll(connection);
        model.addAttribute("personList", personList);
        return "index";
    }

    @GetMapping("/person/{id}/{includeAddress}")
    public Person read(@PathVariable("id") long id,
                       @PathVariable("includeAddress") boolean includeAddress) throws SQLException {

        ConnectionManagement.init();
        Connection connection = ConnectionManagement.getCon();
        Person person = personService.read(connection, id, includeAddress);
        ConnectionManagement.release(connection, true);
        return person;
    }

    @PutMapping("/person")
    public Person create(@RequestBody Person person) throws SQLException {

        ConnectionManagement.init();
        Connection connection = ConnectionManagement.getCon();
        Person createdPerson = personService.create(connection, person);
        ConnectionManagement.release(connection, true);
        return createdPerson;
    }

    @PostMapping("/person/update")
    public Person update(@RequestBody Person person) throws SQLException{

        ConnectionManagement.init();
        Connection connection = ConnectionManagement.getCon();
        if (personService.update(connection, person)) {
            ConnectionManagement.release(connection, true);
        } else {
            ConnectionManagement.release(connection, false);
        }
        return null;
    }

    @PostMapping("/person/delete")
    public void delete(Person person) throws SQLException{

        ConnectionManagement.init();
        Connection connection = ConnectionManagement.getCon();
        person.setId(6);
        personService.delete(connection, person);
        ConnectionManagement.release(connection, true);
    }

}

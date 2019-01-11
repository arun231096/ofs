package com.objectfrontier.training.springRest.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.objectfrontier.training.springRest.connection.ConnectionManagement;
import com.objectfrontier.training.springRest.model.Person;
import com.objectfrontier.training.springRest.service.PersonService;

@RestController
public class RequestController {

    @Autowired
    PersonService service;
    int conn = ConnectionManagement.init();

    @GetMapping
    @RequestMapping("/person")
    public List<Person> readAll() throws SQLException {
        Connection con = ConnectionManagement.myThreadLocal.get();
        List<Person> personList = service.readAll(con);
        ConnectionManagement.release(con, true);
        return personList;
    }

    @PostMapping
    @RequestMapping("/person")
    public Person update(@PathVariable Person updatePerson) throws SQLException {
        Connection con = ConnectionManagement.myThreadLocal.get();
        boolean person = service.update(con, updatePerson);
        ConnectionManagement.release(con, true);
        return updatePerson;
    }

    @PutMapping
    @RequestMapping("/person")
    public Person create(@PathVariable Person createPerson) throws SQLException {
        Connection con = ConnectionManagement.myThreadLocal.get();
        Person person = service.create(con, createPerson);
        ConnectionManagement.release(con, true);
        return person;
    }

    @DeleteMapping
    @RequestMapping("/person")
    public boolean delete(@PathVariable Person delatePerson) throws SQLException {
        Connection con = ConnectionManagement.myThreadLocal.get();
        boolean person = service.delete(con, delatePerson);
        ConnectionManagement.release(con, true);
        return person;
    }

}

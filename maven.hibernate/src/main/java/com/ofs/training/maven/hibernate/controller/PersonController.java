package com.ofs.training.maven.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ofs.training.maven.hibernate.model.Person;
import com.ofs.training.maven.hibernate.service.PersonService;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> readAll() {

        List<Person> userDetails = personService.readAll();
//        ResponseEntity<Person> entity = new ResponseEntity<>(HttpStatus.OK);
//        entity.ok(userDetails);
//        return entity;
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }
}

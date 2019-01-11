package com.ofs.training.maven.hibernate.service;

import java.util.List;

import com.ofs.training.maven.hibernate.model.Person;

public interface PersonService {

    public long create (Person person);
    public List<Person> readAll();
}

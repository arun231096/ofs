package com.ofs.training.maven.hibernate.dao;

import java.util.List;

import com.ofs.training.maven.hibernate.model.Person;

public interface PersonDAO {

    public long create (Person person);
    public List<Person> readAll();
}

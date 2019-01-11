package com.ofs.training.maven.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ofs.training.maven.hibernate.dao.PersonDaoImpl;
import com.ofs.training.maven.hibernate.model.Person;

public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDaoImpl personServiceDao;
    @Override
    public long create(Person person) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Person> readAll() {

        return personServiceDao.readAll();
    }

}

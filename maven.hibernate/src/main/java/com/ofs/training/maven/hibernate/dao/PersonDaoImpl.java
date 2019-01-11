package com.ofs.training.maven.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ofs.training.maven.hibernate.model.Person;

public class PersonDaoImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long create(Person person) {
        // TODO Auto-generated method stub
        return 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> readAll() {

        @SuppressWarnings("deprecation")
        Criteria criteria = sessionFactory.openSession().createCriteria(Person.class);
        return criteria.list();
    }

}

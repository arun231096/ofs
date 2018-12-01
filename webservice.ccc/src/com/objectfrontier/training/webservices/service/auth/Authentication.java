package com.objectfrontier.training.webservices.service.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.objectfrontier.training.webservices.model.Person;
import com.objectfrontier.training.webservices.service.business.AppException;
import com.objectfrontier.training.webservices.service.business.ErrorCodes;
import com.objectfrontier.training.webservices.service.business.Statements;

public class Authentication {

    public Person login(Connection con, Person person) throws SQLException {

        PreparedStatement validate = con.prepareStatement(Statements.LOGIN_VALIDATE.toString());
        validate.setString(1, person.getEmail());
        validate.setString(2, person.getPassword());
        ResultSet resultSet = validate.executeQuery();
        if (resultSet.next()) {
            person.setId(resultSet.getLong("id"));
            person.setFirstname(resultSet.getString("first_name"));
            person.setLastname(resultSet.getString("last_name"));
            person.setIsadmin(resultSet.getBoolean("isadmin"));
            return person;
        } else {
            throw new AppException(ErrorCodes.LOGIN_INVALIDATE);
        }
    }
}

package com.objectfrontier.training.spring_view.utilities;

public interface Statements {

    StringBuilder INSERT_PERSON = new StringBuilder()
                                     .append("INSERT INTO webservice_person      ")
                                     .append("(first_name,                       ")
                                     .append(" last_name,                        ")
                                     .append(" email,                            ")
                                     .append(" `password`,                       ")
                                     .append(" isadmin,                          ")
                                     .append(" birth_date,                       ")
                                     .append("address_id,                        ")
                                     .append(" created_date)                     ")
                                     .append(" VALUES (?, ?, ?, ?, ?, ?,?,?)     ");

    StringBuilder LOGIN_VALIDATE = new StringBuilder()
                                      .append("SELECT                       ")
                                      .append(" id,                         ")
                                      .append(" first_name,                 ")
                                      .append(" last_name,                  ")
                                      .append(" email,                      ")
                                      .append(" `password`,                 ")
                                      .append(" isadmin                     ")
                                      .append("  FROM webservice_person     ")
                                      .append(" WHERE email = ?             ")
                                      .append("   AND `password` = ?        ");


    StringBuilder UPDATE_PERSON = new StringBuilder()
                                     .append("UPDATE webservice_person  ")
                                     .append("SET                       ")
                                     .append(" first_name = ?,          ")
                                     .append(" last_name = ?,           ")
                                     .append(" email = ?,               ")
                                     .append(" `password` = ?,          ")
                                     .append(" isadmin = ?,             ")
                                     .append(" birth_date = ?           ")
                                     .append("WHERE id = ?              ");

    StringBuilder READ_ALL_PERSON = new StringBuilder()
                                       .append("SELECT                    ")
                                       .append(" id,                      ")
                                       .append(" first_name,              ")
                                       .append(" last_name,               ")
                                       .append(" email,                   ")
//                                       .append(" `password`,               ")
                                       .append(" isadmin,                 ")
                                       .append(" address_id,              ")
                                       .append(" birth_date,              ")
                                       .append(" created_date             ")
                                       .append("FROM webservice_person    ");

    StringBuilder READ_PERSON = new StringBuilder()
                                   .append("SELECT                       ")
                                   .append(" id,                         ")
                                   .append(" first_name,                 ")
                                   .append(" last_name,                  ")
                                   .append(" email,                      ")
//                                   .append(" `password`,               ")
                                   .append(" isadmin,                    ")
                                   .append(" address_id,                 ")
                                   .append(" birth_date,                 ")
                                   .append(" created_date                ")
                                   .append("FROM webservice_person       ")
                                   .append("WHERE id = ?        ");

    StringBuilder DELETE_PERSON = new StringBuilder()
                                      .append("DELETE                   ")
                                      .append("  FROM webservice_person ")
                                      .append(" WHERE id = ?            ");

    StringBuilder INSERT_ADDRESS = new StringBuilder()
                                      .append("INSERT INTO webservice_address ")
                                      .append("(street,                       ")
                                      .append(" city,                         ")
                                      .append(" postal_code)                  ")
                                      .append("VALUES (?,?,?)                 ");

    StringBuilder UPDATE_ADDRESS = new StringBuilder()
                                      .append("UPDATE webservice_address  ")
                                      .append("   SET                     ")
                                      .append(" street = ?,               ")
                                      .append(" city = ?,                 ")
                                      .append(" postal_code = ?           ")
                                      .append(" WHERE id = ?              ");

    StringBuilder READ_ADDRESS = new StringBuilder()
                                    .append("SELECT                      ")
                                    .append(" id,                        ")
                                    .append(" street,                    ")
                                    .append(" city,                      ")
                                    .append(" postal_code                ")
                                    .append("  FROM webservice_address   ")
                                    .append(" WHERE id = ?               ");

    StringBuilder READ_ALL_ADDRESS = new StringBuilder()
                                        .append("SELECT                    ")
                                        .append(" id,                      ")
                                        .append(" street,                  ")
                                        .append(" city,                    ")
                                        .append(" postal_code              ")
                                        .append(" FROM webservice_address  ");

    StringBuilder DELETE_ADDRESS =new StringBuilder()
                                     .append("DELETE FROM webservice_address ")
                                     .append("WHERE id = ?                   ");

    StringBuilder SEARCH_ADDRESS = new StringBuilder()
                                      .append("SELECT                     ")
                                      .append(" id,                       ")
                                      .append(" street,                   ")
                                      .append(" city,                     ")
                                      .append(" postal_code               ")
                                      .append(" FROM webservice_address   ")
                                      .append(" WHERE                     ");

}

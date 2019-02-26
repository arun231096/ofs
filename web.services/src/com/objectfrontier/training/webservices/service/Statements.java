package com.objectfrontier.training.webservices.service;

public interface Statements {

    StringBuilder INSERT_PERSON = new StringBuilder()
                                     .append("INSERT INTO sr_person     ")
                                     .append("(first_name,               ")
                                     .append(" last_name,                ")
                                     .append(" email,                    ")
                                     .append(" birth_date,               ")
                                     .append("address_id,                ")
                                     .append(" created_date)             ")
                                     .append(" VALUES (?, ?, ?, ?, ?, ?) ");

    StringBuilder UPDATE_PERSON = new StringBuilder()
                                     .append("UPDATE sr_person  ")
                                     .append("SET               ")
                                     .append(" first_name = ?,  ")
                                     .append(" last_name = ?,   ")
                                     .append(" email = ?,       ")
                                     .append(" birth_date = ?   ")
                                     .append("WHERE id = ?      ");

    StringBuilder READ_ALL_PERSON = new StringBuilder()
                                       .append("SELECT           ")
                                       .append(" id,             ")
                                       .append(" first_name,     ")
                                       .append(" last_name,      ")
                                       .append(" email,          ")
                                       .append(" address_id,     ")
                                       .append(" birth_date,     ")
                                       .append(" created_date    ")
                                       .append("FROM sr_person   ");

    StringBuilder READ_PERSON = new StringBuilder()
                                   .append("SELECT              ")
                                   .append(" id,                ")
                                   .append(" first_name,        ")
                                   .append(" last_name,         ")
                                   .append(" email,             ")
                                   .append(" address_id,        ")
                                   .append(" birth_date,        ")
                                   .append(" created_date       ")
                                   .append("FROM sr_person      ")
                                   .append("WHERE id = ?        ");

    StringBuilder DELETE_PERSON = new StringBuilder()
                                      .append("DELETE           ")
                                      .append("  FROM sr_person ")
                                      .append(" WHERE id = ?    ");

    StringBuilder INSERT_ADDRESS = new StringBuilder()
                                      .append("INSERT INTO sr_address ")
                                      .append("(street,               ")
                                      .append(" city,                 ")
                                      .append(" postal_code)          ")
                                      .append("VALUES (?,?,?)         ");

    StringBuilder UPDATE_ADDRESS = new StringBuilder()
                                      .append("UPDATE sr_address  ")
                                      .append("   SET             ")
                                      .append(" street = ?,       ")
                                      .append(" city = ?,         ")
                                      .append(" postal_code = ?   ")
                                      .append(" WHERE id = ?      ");

    StringBuilder READ_ADDRESS = new StringBuilder()
                                    .append("SELECT             ")
                                    .append(" id,               ")
                                    .append(" street,           ")
                                    .append(" city,             ")
                                    .append(" postal_code       ")
                                    .append("  FROM sr_address  ")
                                    .append(" WHERE id = ?      ");

    StringBuilder READ_ALL_ADDRESS = new StringBuilder()
                                        .append("SELECT            ")
                                        .append(" id,              ")
                                        .append(" street,          ")
                                        .append(" city,            ")
                                        .append(" postal_code      ")
                                        .append(" FROM sr_address  ");

    StringBuilder DELETE_ADDRESS =new StringBuilder()
                                     .append("DELETE FROM sr_address ")
                                     .append("WHERE id = ? ");

    StringBuilder SEARCH_ADDRESS = new StringBuilder()
                                      .append("SELECT             ")
                                      .append(" id,               ")
                                      .append(" street,           ")
                                      .append(" city,             ")
                                      .append(" postal_code       ")
                                      .append(" FROM sr_address   ")
                                      .append(" WHERE             ");

}

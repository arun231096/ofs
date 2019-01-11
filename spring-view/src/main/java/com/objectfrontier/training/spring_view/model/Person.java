package com.objectfrontier.training.spring_view.model;

import java.sql.Timestamp;

public class Person {

    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private boolean isadmin;
    private String dob;
    private Timestamp createdDate;
    private Address address;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public Person(String firstname, String lastname, String email, String password, boolean isadmin, String dob,
            Timestamp createdDate, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.isadmin = isadmin;
        this.dob = dob;
        this.createdDate = createdDate;
        this.address = address;
    }
    public Person() {
        // TODO Auto-generated constructor stub
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isIsadmin() {
        return isadmin;
    }
    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public Timestamp getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}

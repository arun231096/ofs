package com.objectfrontier.training.java.jdbc.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class Person {

    long id;
    String name;
    String email;
    Date dob;
    Timestamp createdDate;
    Address address;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public Timestamp getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
//        builder.append("Person [id=");
//        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", email=");
        builder.append(email);
        builder.append(", dob=");
        builder.append(dob);
        builder.append(", createdDate=");
        builder.append(createdDate);
        builder.append(", address=");
        builder.append(address);
        builder.append("]");
        return builder.toString();
    }
}

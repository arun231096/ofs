package com.ofs.training.Hibernate.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personTable")
public class Person {

    @Id
    @Column(name="id")
    int userId;
    @Column(name="first_name")
    String firstname;
    @Column(name="last_name")
    String lastname;
    @Column(name="email")
    String email;
    @Column(name="birth_date")
    String birthDate;
    @Column(name="isAdmin")
    Boolean isAdmin;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
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
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Person(String firstname, String lastname, String email, String birthDate, Boolean isAdmin) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthDate = birthDate;
        this.isAdmin = isAdmin;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person [userId=");
        builder.append(userId);
        builder.append(", firstname=");
        builder.append(firstname);
        builder.append(", lastname=");
        builder.append(lastname);
        builder.append(", email=");
        builder.append(email);
        builder.append(", birthDate=");
        builder.append(birthDate);
        builder.append(", isAdmin=");
        builder.append(isAdmin);
        builder.append("]");
        return builder.toString();
    }
}

package com.objectfrontier.training.spring_view.model;

public class Address {

    private long id;
    private String street;
    private String city;
    private int postal_code;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Address(String street, String city, int postal_code) {
        super();
        this.street = street;
        this.city = city;
        this.postal_code = postal_code;
    }
    public Address() {
        // TODO Auto-generated constructor stub
    }
    public int getPostal_code() {
        return postal_code;
    }
    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }
}

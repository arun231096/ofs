package com.objectfrontier.training.java.jdbc.pojo;

public class Address {

    long id;
    String street;
    String city;
    int postal_code;
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
    public int getPostal_code() {
        return postal_code;
    }
    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
//        builder.append("Address [id=");
//        builder.append(id);
        builder.append(", street=");
        builder.append(street);
        builder.append(", city=");
        builder.append(city);
        builder.append(", postal_code=");
        builder.append(postal_code);
        builder.append("]");
        return builder.toString();
    }
}

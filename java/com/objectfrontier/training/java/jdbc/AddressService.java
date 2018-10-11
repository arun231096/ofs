package com.objectfrontier.training.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.objectfrontier.training.java.jdbc.pojo.Address;

public class AddressService {

    String street;
    String city;
    int postal_code;
    private Connection con;
    private PreparedStatement checkAddress;
    private PreparedStatement createAddress;
    private PreparedStatement readAddress;
    private PreparedStatement updatecity;
    private PreparedStatement updateStreet;
    private PreparedStatement updatepostal_code;
    private PreparedStatement readAllAddress;
    private PreparedStatement deleteAddress;
    private ResultSet result;

    public AddressService() throws SQLException {
        setCon(ConnectionManagement.getConnection());
        checkAddress = con.prepareStatement("SELECT id "
                                            + "FROM address "
                                           + "WHERE street = ? AND city = ? AND postal_code = ?");
        createAddress = con.prepareStatement("INSERT INTO address (street, city, postal_code)"
                                           + "VALUES (?,?,?)");
        readAddress = con.prepareStatement("SELECT street, city, postal_code "
                                          +  "FROM address"
                                          + "WHERE id = ?");
        updatecity = con.prepareStatement("UPDATE address "
                                         +   "SET city = ? "
                                         + "WHERE id = ?");
        updateStreet = con.prepareStatement("UPDATE address "
                +   "SET street = ? "
                + "WHERE id = ?");
        updatepostal_code = con.prepareStatement("UPDATE address "
                +   "SET postal_code = ? "
                + "WHERE id = ?");
        readAllAddress = con.prepareStatement("SELECT street, city, postal_code"
                                              + "FROM address");
        deleteAddress = con.prepareStatement("DELETE FROM address"
                                            + "WHERE id = ?");
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public int create (Address address) throws SQLException {

        int address_id = 0;
            createAddress.setString(1, address.getStreet());
            createAddress.setString(2, address.getCity());
            createAddress.setInt(3, address.getPostal_code());
            if (createAddress.executeUpdate() > 0) {
                System.out.println("created");
                ResultSet result = checkAddress.executeQuery();
                if (result.next())
                    address_id = result.getInt("id");
                System.out.println("Address created " + address_id);
                return address_id;
            }
        return 0;
    }

    public void read (int id) throws SQLException {

        readAddress.setInt(1, id);
        ResultSet result = readAddress.executeQuery();
        if (result.next()) {
        street = result.getString("street");
        city = result.getString("city");
        postal_code = result.getInt("postal_code");
        }
    }

    public ResultSet readAll () throws SQLException {

        result = readAllAddress.executeQuery();
        return result;
    }

    public void update(int id, String updateFiled, String field) throws SQLException {

        if (field.equals("street")) {
            updateStreet.setString(1, updateFiled);
            updateStreet.setInt(2, id);
            if (updateStreet.execute()) {
                System.out.println("street Update Sucessfully");
            } else {
                System.out.println("Update Failed");
            }
        } else if (field.equals("city")) {
            updatecity.setString(1, updateFiled);
            updatecity.setInt(2, id);
            if (updatecity.execute()) {
                System.out.println("City update Sucess");
            } else {
                System.out.println("Update Failed");
            }
        } else if (field.equals("postal_code")){
            updatepostal_code.setInt(1, Integer.parseInt(updateFiled));
            updatepostal_code.setInt(2, id);
            if (updatepostal_code.execute()) {
                System.out.println("postal code Updated");
            } else {
                System.out.println("Update Failed");
            }
        } else {
            System.out.println("Mismatched filed");
        }
    }

    public void delete(int id) throws SQLException {

        deleteAddress.setInt(1, id);
        if (deleteAddress.execute()) {
            System.out.println("Address Deleted");
        } else {
            System.out.println("Cannot delete");
        }
    }

    public void close() throws SQLException {

        checkAddress.close();
        createAddress.close();
        deleteAddress.close();
        updatecity.close();
        updatepostal_code.close();
        updateStreet.close();
        readAddress.close();
        readAllAddress.close();
        con.close();
    }
}

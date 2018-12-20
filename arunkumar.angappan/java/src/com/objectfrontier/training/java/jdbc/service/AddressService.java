package com.objectfrontier.training.java.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.objectfrontier.training.java.jdbc.pojo.Address;

public class AddressService {

    Address address;
    private PreparedStatement createAddress;
    private PreparedStatement readAddress;
    private PreparedStatement updateAddress;
    private PreparedStatement readAllAddress;
    private PreparedStatement deleteAddress;
    private ResultSet result;

    public Address create (Connection con, Address address) throws SQLException, ServiceException {

                createAddress = con.prepareStatement( new StringBuilder()
                        .append("INSERT INTO address (street, city, postal_code) ")
                        .append("VALUES (?,?,?) ").toString(), Statement.RETURN_GENERATED_KEYS);

                createAddress.setString(1, address.getStreet());
                createAddress.setString(2, address.getCity());
                createAddress.setInt(3, address.getPostal_code());
                if (createAddress.executeUpdate() > 0) {
                    ResultSet resultSet = createAddress.getGeneratedKeys();
                    resultSet.next();
                    address.setId(resultSet.getInt(1));
                    createAddress.close();
                } else { throw new ServiceException("Cannot create Address"); }
        return address;
    }

    public Address read (Connection con, long id) throws SQLException, ServiceException {

        readAddress = con.prepareStatement( new StringBuilder()
                .append("SELECT id, street, city, postal_code ")
                .append("  FROM address ")
                .append(" WHERE id = ? ").toString());

            readAddress.setLong(1, id);
            address = new Address();
            ResultSet result = readAddress.executeQuery();
                if (result.next()) {
                    address.setId(result.getLong("id"));
                    address.setStreet(result.getString("street"));
                    address.setCity(result.getString("city"));
                    address.setPostal_code(result.getInt("postal_code"));
                } else { throw new ServiceException(" Address not exists in this Id " + id); }
            return address;
    }

    public List<Address> readAll (Connection con) throws SQLException {

        List<Address> addressList = new ArrayList<>();
            readAllAddress = con.prepareStatement( new StringBuilder()
                    .append("SELECT id, street, city, postal_code ")
                    .append("FROM address").toString());

            result = readAllAddress.executeQuery();
            while (result.next()) {
                Address addr = new Address();
                addr.setId(result.getLong("id"));
                addr.setStreet(result.getString("street"));
                addr.setCity(result.getString("city"));
                addr.setPostal_code(result.getInt("postal_code"));
                addressList.add(addr);
            }
        return addressList;
    }

    public boolean update(Connection con, Address address) throws SQLException, ServiceException {

            updateAddress = con.prepareStatement( new StringBuilder()
                     .append("UPDATE address ")
                     .append("SET street = ?, city = ?, postal_code = ? ")
                     .append("WHERE id = ? ").toString());
            updateAddress.setString(1, address.getStreet());
            updateAddress.setString(2, address.getCity());
            updateAddress.setInt(3, address.getPostal_code());
            updateAddress.setLong(4, address.getId());
            if (updateAddress.executeUpdate() > 0) { return true; }
            else { throw new ServiceException("Address Not available"); }
    }

    public boolean delete(Connection con, Address address) throws SQLException, ServiceException {

            deleteAddress = con.prepareStatement( new StringBuilder()
                    .append("DELETE FROM address ")
                    .append("WHERE id = ? ").toString());
            deleteAddress.setLong(1, address.getId());
            if (deleteAddress.executeUpdate() > 0) {
                return true;
            } else { throw new ServiceException("Address Not available"); }
    }

//    public void log (String format, String message) {
//        System.out.format(format, message);
//    }
}

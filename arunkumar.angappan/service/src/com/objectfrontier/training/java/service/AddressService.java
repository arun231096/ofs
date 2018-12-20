package com.objectfrontier.training.java.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.objectfrontier.training.java.pojo.Address;

public class AddressService {

    public Address create (Connection con, Address address) throws SQLException, AppException {

        validateAddress(address);
        PreparedStatement createAddress = con.prepareStatement( new StringBuilder()
                .append("INSERT INTO sr_address (street, city, postal_code) ")
                .append("VALUES (?,?,?) ").toString(), Statement.RETURN_GENERATED_KEYS);

        createAddress = prepareAddress(createAddress, address);
        if (createAddress.executeUpdate() > 0) {
            ResultSet resultSet = createAddress.getGeneratedKeys();
            resultSet.next();
            address.setId(resultSet.getInt(1));
            createAddress.close();
        } else { throw new AppException(ErrorCodes.CREATE_ADDRESS_ERROR); }
        return address;
    }

    public boolean update(Connection con, Address updatedAddress) throws SQLException, AppException {

        validateAddress(updatedAddress);
        PreparedStatement updateAddress = con.prepareStatement( new StringBuilder()
                .append("UPDATE sr_address ")
                .append("SET street = ?, city = ?, postal_code = ? ")
                .append("WHERE id = ? ").toString());
       updateAddress = prepareAddress(updateAddress, updatedAddress);
       updateAddress.setLong(4, updatedAddress.getId());
       if (updateAddress.executeUpdate() > 0) {
           return true;
       }
       else { throw new AppException(ErrorCodes.ADDRESS_IDENTITFICATION_ERROR); }
    }

    public PreparedStatement prepareAddress(PreparedStatement setStatement, Address addressSet) throws SQLException {

        setStatement.setString(1, addressSet.getStreet());
        setStatement.setString(2, addressSet.getCity());
        setStatement.setInt(3, addressSet.getPostal_code());
        return setStatement;
    }

    private void validateAddress(Address address) {

        if ((address.getCity()!= null)  && (address.getStreet() != null)) {
            if (address.getCity().trim().isEmpty() || address.getStreet().trim().isEmpty() || address.getPostal_code() == 0) {
                throw new AppException(ErrorCodes.ADDRESS_FILED_EMPTY_ERROR);
            }
        } else {
            throw new AppException(ErrorCodes.ADDRESS_FILED_EMPTY_ERROR);
        }
    }

    public Address read (Connection con, long id) throws AppException, SQLException {

        PreparedStatement readAddress = con.prepareStatement( new StringBuilder()
                .append("SELECT id, street, city, postal_code ")
                .append("  FROM sr_address ")
                .append(" WHERE id = ? ").toString());
        readAddress.setLong(1, id);
        Address address = new Address();
        ResultSet result = readAddress.executeQuery();
            if (result.next()) {
                address = setAddress(result);
            } else { throw new AppException(ErrorCodes.ADDRESS_IDENTITFICATION_ERROR); }
        return address;
    }

    public List<Address> readAll (Connection con) throws SQLException {


            List<Address> addressList = new ArrayList<>();
            PreparedStatement readAllAddress = con.prepareStatement( new StringBuilder()
                    .append("SELECT id, street, city, postal_code ")
                    .append("FROM sr_address").toString());
                ResultSet result = readAllAddress.executeQuery();
                while (result.next()) {
                    Address addr = new Address();
                    addr = setAddress(result);
                    addressList.add(addr);
                }
            return addressList;
    }

    public Address setAddress(ResultSet addressSet) throws SQLException {
        Address addr = new Address();
        addr.setId(addressSet.getLong("id"));
        addr.setStreet(addressSet.getString("street"));
        addr.setCity(addressSet.getString("city"));
        addr.setPostal_code(addressSet.getInt("postal_code"));
        return addr;
    }

    public boolean delete(Connection con, Address deletingAddress) throws SQLException, AppException {

        PreparedStatement deleteAddress = con.prepareStatement( new StringBuilder()
                .append("DELETE FROM sr_address ")
                .append("WHERE id = ? ").toString());
        deleteAddress.setLong(1, deletingAddress.getId());
        if (deleteAddress.executeUpdate() > 0) {
            return true;
        } else { throw new AppException(ErrorCodes.ADDRESS_IDENTITFICATION_ERROR); }
}

    public List<Address> search(Connection con, String data, String[] option) throws SQLException {
        List <Address> searchList = new ArrayList<>();
        StringBuilder searchQuery = new StringBuilder()
                .append("SELECT id, street, city, postal_code FROM sr_address WHERE ");
        for (int i = 0; i < option.length; i++) {
            if (i > 0) { searchQuery.append(" OR "); }
            if ("street".equals(option[i])) {
            searchQuery.append("street LIKE ?");
            } else if ("city".equals(option[i])) {
            searchQuery.append("city LIKE ?");
            } else if ("postal code".equals(option[i])) {
            searchQuery.append("postal_code LIKE ?");
            }
        }
        PreparedStatement statement = con.prepareStatement(searchQuery.toString());
        for (int i = 1; i <= option.length; i++ ) {
            statement.setString(i, "%" + data + "%");
        }
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            Address address = new Address();
            address = setAddress(result);
            searchList.add(address);
        }
        return searchList;
    }

//    public void log (String format, String message) {
//        System.out.format(format, message);
//    }
}

package com.objectfrontier.training.webservices.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.objectfrontier.training.webservices.pojo.Address;

public class AddressService {

    public Address create (Connection con, Address address) throws SQLException {

        validateAddress(address);
        PreparedStatement createAddress;
        createAddress = con.prepareStatement( Statements.INSERT_ADDRESS.toString(), Statement.RETURN_GENERATED_KEYS);
        createAddress = prepareAddress(createAddress, address);
        if (createAddress.executeUpdate() > 0) {
            ResultSet resultSet = createAddress.getGeneratedKeys();
            resultSet.next();
            address.setId(resultSet.getInt(1));
        } else { throw new AppException(ErrorCodes.CREATE_ADDRESS_ERROR); }
        return address;
    }

    public boolean update(Connection con, Address updatedAddress) throws SQLException {

        validateAddress(updatedAddress);
        PreparedStatement updateAddress;
        updateAddress = con.prepareStatement(Statements.UPDATE_ADDRESS.toString());
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

        List<ErrorCodes> errorList = new ArrayList<>();
        if ((address.getCity() == null) || (address.getCity().trim().isEmpty())) {
            errorList.add(ErrorCodes.ADDRESS_FILED_EMPTY_CITY);
        } if ((address.getStreet() == null) || (address.getStreet().trim().isEmpty())) {
            errorList.add(ErrorCodes.ADDRESS_FILED_EMPTY_STREET);
        } if (address.getPostal_code() == 0 ) {
            errorList.add(ErrorCodes.ADDRESS_FILED_EMPTY_POSTAL_CODE);
        }
        if (errorList.isEmpty() != true) {
            throw new AppException(errorList);
        }
    }

    public Address read (Connection con, long id) throws SQLException {

        Address address = new Address();
        PreparedStatement readAddress = con.prepareStatement(Statements.READ_ADDRESS.toString());
        readAddress.setLong(1, id);
        ResultSet result = readAddress.executeQuery();
        if (result.next()) {
            address = setAddress(result);
        } else { throw new AppException(ErrorCodes.ADDRESS_IDENTITFICATION_ERROR); }
        return address;
    }

    public List<Address> readAll (Connection con) throws SQLException {


        List<Address> addressList = new ArrayList<>();
        PreparedStatement readAllAddress;
        readAllAddress = con.prepareStatement(Statements.READ_ALL_ADDRESS.toString());
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

    public boolean delete(Connection con, Address deletingAddress) throws SQLException {

        PreparedStatement deleteAddress;
            deleteAddress = con.prepareStatement(Statements.DELETE_ADDRESS.toString());
            deleteAddress.setLong(1, deletingAddress.getId());
            if (deleteAddress.executeUpdate() > 0) {
                return true;
            } else { throw new AppException(ErrorCodes.ADDRESS_IDENTITFICATION_ERROR); }
}

    public List<Address> search(Connection con, String data, String[] option) throws SQLException {
        List <Address> searchList = new ArrayList<>();
        StringBuilder searchQuery = Statements.SEARCH_ADDRESS;
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
        PreparedStatement statement;
        statement = con.prepareStatement(searchQuery.toString());
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

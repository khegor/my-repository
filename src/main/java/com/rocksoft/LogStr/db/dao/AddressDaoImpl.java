package com.rocksoft.LogStr.db.dao;

import com.rocksoft.LogStr.db.models.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Esenin on 24.09.2017.
 */
public class AddressDaoImpl extends AbstarctDao implements AddressDao {

    @Override
    public void createAddress(Address address) {
        PreparedStatement preparedStatement = getPreparedStatement("INSERT INTO addresses (COUNTRY, CITY, STREET, HOME_NUMBER) VALUES (?, ?, ?, ?)");
        try {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getHomeNumber());

            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
            closeConnection();
        }
    }

    @Override
    public synchronized Address getAddressById(long id) {
        PreparedStatement preparedStatement = getPreparedStatement("SELECT * FROM addresses WHERE ID = ?");
        Address address = null;
        try {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            address = new Address();
            address.setId(resultSet.getLong("ID"));
            address.setCity(resultSet.getString("CITY"));
            address.setCountry(resultSet.getString("COUNTRY"));
            address.setStreet(resultSet.getString("STREET"));
            address.setHomeNumber(resultSet.getString("HOME_NUMBER"));

        } catch (SQLException e) {
            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection();
        }
        return address;
    }

    @Override
    public List<Address> getAllAddresses() {
        PreparedStatement preparedStatement = getPreparedStatement("SELECT * FROM addresses");
        Address address = null;
        List<Address> addresses = new ArrayList<>();

        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                address = new Address();
                address.setId(resultSet.getLong("ID"));
                address.setCity(resultSet.getString("CITY"));
                address.setCountry(resultSet.getString("COUNTRY"));
                address.setStreet(resultSet.getString("STREET"));
                address.setHomeNumber(resultSet.getString("HOME_NUMBER"));

                addresses.add(address);
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection();
        }

        return addresses;
        
    }

    @Override
    public void updateAddress(Address address) {
        PreparedStatement preparedStatement = getPreparedStatement("UPDATE addresses SET CITY = ?, COUNTRY = ?, STREET = ?, HOME_NUMBER = ? WHERE ID = ?");

        try {
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getHomeNumber());
            preparedStatement.setLong(5, address.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection();
        }
    }

    @Override
    public void deleteAddressById(long id) {
        PreparedStatement preparedStatement = getPreparedStatement("DELETE FROM addresses WHERE ID = ?");

        try {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {

            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection();
        }
    }
}

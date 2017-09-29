package com.rocksoft.LogStr.db.dao.daoImpl;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.daoInterf.AddressDao;
import com.rocksoft.LogStr.db.models.Address;

import java.sql.Connection;
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO addresses (COUNTRY, CITY, STREET, HOME_NUMBER) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getHomeNumber());

            preparedStatement.execute();
        } catch (Exception e) {
            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
            closeConnection(connection);
        }
    }

    @Override
    public synchronized Address getAddressById(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Address address = null;
        try {
            connection = getConnection();
            connection.prepareStatement("SELECT * FROM addresses WHERE ID = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            address = new Address();
            address.setId(resultSet.getLong("ID"));
            address.setCity(resultSet.getString("CITY"));
            address.setCountry(resultSet.getString("COUNTRY"));
            address.setStreet(resultSet.getString("STREET"));
            address.setHomeNumber(resultSet.getString("HOME_NUMBER"));

        } catch (Exception e) {
            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }
        return address;
    }

    @Override
    public List<Address> getAllAddresses() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Address address = null;
        List<Address> addresses = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM addresses");
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

        } catch (Exception e) {
            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }

        return addresses;
        
    }

    @Override
    public void updateAddress(Address address) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("UPDATE addresses SET CITY = ?, COUNTRY = ?, STREET = ?, HOME_NUMBER = ? WHERE ID = ?");
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getHomeNumber());
            preparedStatement.setLong(5, address.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }
    }

    @Override
    public void deleteAddressById(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM addresses WHERE ID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (Exception e) {

            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }
    }
}

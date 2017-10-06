package com.rocksoft.LogStr.db.dao.Impl;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.StorekeeperDao;
import com.rocksoft.LogStr.db.models.Address;
import com.rocksoft.LogStr.db.models.Storekeeper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Esenin on 29.09.2017.
 */
public class StorekeeperDaoImpl extends AbstarctDao implements StorekeeperDao{


    @Override
    public void createStorekeeper(Storekeeper storekeeper) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO storekeepers (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH) " +
                    "VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, storekeeper.getName());
            preparedStatement.setString(2, storekeeper.getSurname());
            preparedStatement.setString(3, storekeeper.getEstablishedPost());
            preparedStatement.setString(4, String.valueOf(storekeeper.getDateOfBirth()));
        } catch(Exception e){
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }

    }


    @Override
    public Storekeeper getStorekeeperById(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Storekeeper storekeeper = null;
        Address address = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM storekeepers L JOIN ADDRESSES A ON A.ID=L.ADDRESSES_ID " +
                    "WHERE L.ID = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            storekeeper = new Storekeeper();
            address = new Address();

            storekeeper.setId(resultSet.getLong("ID"));
            storekeeper.setName(resultSet.getString("NAME"));
            storekeeper.setSurname(resultSet.getString("SURNAME"));
            storekeeper.setEstablishedPost(resultSet.getString("ESTABLISHED_POST"));
            storekeeper.setDateOfBirth(resultSet.getString("DATE_OF_BIRTH"));

            address.setCountry(resultSet.getString("COUNTRY"));
            address.setCity(resultSet.getString("CITY"));
            address.setStreet(resultSet.getString("STREET"));
            address.setHomeNumber(resultSet.getString("HOME_NUMBER"));
            storekeeper.setAddress(address);

        } catch (Exception e) {
            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (Exception e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }
        return storekeeper;
    }


    @Override
    public void updateStorekeeper(Storekeeper storekeeper) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("UPDATE storekeepers SET NAME = ?, SURNAME = ?, ESTABLISHED_POST = ?, DATE_OF_BIRTH = ? " +
                    "WHERE ID = ?");

            preparedStatement.setString(1, storekeeper.getName());
            preparedStatement.setString(2, storekeeper.getSurname());
            preparedStatement.setString(3, storekeeper.getEstablishedPost());
            preparedStatement.setString(4, String.valueOf(storekeeper.getDateOfBirth()));
            preparedStatement.setLong(5, storekeeper.getId());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }closeConnection(connection);
        }
    }


    @Override
    public void deleteStorekeeperById(long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM storekeepers WHERE ID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            closeConnection(connection);
        }
    }
}

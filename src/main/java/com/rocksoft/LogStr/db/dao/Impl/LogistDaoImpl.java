package com.rocksoft.LogStr.db.dao.Impl;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.LogistDao;
import com.rocksoft.LogStr.db.models.Address;
import com.rocksoft.LogStr.db.models.Logist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Esenin on 29.09.2017.
 */
public class LogistDaoImpl extends AbstarctDao implements LogistDao{


    @Override
    public void createLogist(Logist logist) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO logists (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH) " +
                    "VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, logist.getName());
            preparedStatement.setString(2, logist.getSurname());
            preparedStatement.setString(3, logist.getEstablishedPost());
            preparedStatement.setString(4, String.valueOf(logist.getDateOfBirth()));
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
    public Logist getLogistById(long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Logist logist = null;
        Address address = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM logists L JOIN ADDRESSES A ON A.ID=L.ADDRESSES_ID " +
                    "WHERE L.ID = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            logist = new Logist();
            address = new Address();

            logist.setId(resultSet.getLong("ID"));
            logist.setName(resultSet.getString("NAME"));
            logist.setSurname(resultSet.getString("SURNAME"));
            logist.setEstablishedPost(resultSet.getString("ESTABLISHED_POST"));
            logist.setDateOfBirth(resultSet.getString("DATE_OF_BIRTH"));

            address.setCountry(resultSet.getString("COUNTRY"));
            address.setCity(resultSet.getString("CITY"));
            address.setStreet(resultSet.getString("STREET"));
            address.setHomeNumber(resultSet.getString("HOME_NUMBER"));
            logist.setAddress(address);

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
        return logist;
    }


    @Override
    public void updateLogist(Logist logist) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("UPDATE logists SET NAME = ?, SURNAME = ?, ESTABLISHED_POST = ?, DATE_OF_BIRTH = ? " +
                    "WHERE ID = ?");

            preparedStatement.setString(1, logist.getName());
            preparedStatement.setString(2, logist.getSurname());
            preparedStatement.setString(3, logist.getEstablishedPost());
            preparedStatement.setString(4, String.valueOf(logist.getDateOfBirth()));
            preparedStatement.setLong(5, logist.getId());

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
    public void deleteLogistById(long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM logists WHERE ID = ?");
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

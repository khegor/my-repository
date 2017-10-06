package com.rocksoft.LogStr.db.dao.Impl;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.DirectorDao;
import com.rocksoft.LogStr.db.models.Address;
import com.rocksoft.LogStr.db.models.Director;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Esenin on 26.09.2017.
 */
public class DirectorDaoImpl extends AbstarctDao implements DirectorDao {


    @Override
    public void createDirector(Director director) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO directors (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH) " +
                    "VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, director.getName());
            preparedStatement.setString(2, director.getSurname());
            preparedStatement.setString(3, director.getEstablishedPost());
            preparedStatement.setString(4, String.valueOf(director.getDateOfBirth()));

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
    public Director getDirectorById(long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Director director = null;
        Address address = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM directors D JOIN ADDRESSES A ON A.ID=D.ADDRESSES_ID " +
                    "WHERE D.ID = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            director = new Director();
            address = new Address();

            director.setId(resultSet.getLong("ID"));
            director.setName(resultSet.getString("NAME"));
            director.setSurname(resultSet.getString("SURNAME"));
            director.setEstablishedPost(resultSet.getString("ESTABLISHED_POST"));
            director.setDateOfBirth(resultSet.getString("DATE_OF_BIRTH"));

            address.setCountry(resultSet.getString("COUNTRY"));
            address.setCity(resultSet.getString("CITY"));
            address.setStreet(resultSet.getString("STREET"));
            address.setHomeNumber(resultSet.getString("HOME_NUMBER"));
            director.setAddress(address);

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
        return director;
    }

    @Override
    public void updateDirector(Director director) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("UPDATE directors SET NAME = ?, SURNAME = ?, ESTABLISHED_POST = ?, DATE_OF_BIRTH = ? " +
                    "WHERE ID = ?");

            preparedStatement.setString(1, director.getName());
            preparedStatement.setString(2, director.getSurname());
            preparedStatement.setString(3, director.getEstablishedPost());
            preparedStatement.setString(4, String.valueOf(director.getDateOfBirth()));
            preparedStatement.setLong(5, director.getId());

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
    public void deleteDirectorById(long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM directors WHERE ID = ?");
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

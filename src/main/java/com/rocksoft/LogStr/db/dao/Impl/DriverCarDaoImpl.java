package com.rocksoft.LogStr.db.dao.Impl;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.DriverCarDao;
import com.rocksoft.LogStr.db.models.Address;
import com.rocksoft.LogStr.db.models.Car;
import com.rocksoft.LogStr.db.models.DriverCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Esenin on 25.09.2017.
 */
public class DriverCarDaoImpl extends AbstarctDao implements DriverCarDao {


    @Override
    public void createDriverCar(DriverCar driver) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO drivers (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH, " +
                    "ADDRESSES_ID) VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getSurname());
            preparedStatement.setString(3, driver.getEstablishedPost());
            preparedStatement.setString(4, String.valueOf(driver.getDateOfBirth()));
            preparedStatement.setLong(5, driver.getAddress().getId());
            preparedStatement.execute();
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                LOGGER.info(e);
            }
            closeConnection(connection);
        }
    }


    @Override
    public DriverCar getDriverCarById(long id) {


        DriverCar driverCar = null;
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT D.ID, D.NAME, D.SURNAME, D.ESTABLISHED_POST, " +
                    "D.DATE_OF_BIRTH FROM drivers D WHERE D.ID = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            driverCar = new DriverCar();


                driverCar.setId(resultSet.getLong("ID"));
                driverCar.setName(resultSet.getString("NAME"));
                driverCar.setSurname(resultSet.getString("SURNAME"));
                driverCar.setEstablishedPost(resultSet.getString("ESTABLISHED_POST"));
                driverCar.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH"));

        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }
        return driverCar;
    }


    @Override
    public List<DriverCar> getAllDriverCar() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DriverCar driverCar = null;
        List<DriverCar> driverCars = new ArrayList<>();
        Address address = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM drivers D JOIN addresses A ON D.ADDRESSES_ID = A.ID");

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                driverCar = new DriverCar();
                driverCar.setId(resultSet.getLong("ID"));
                driverCar.setName(resultSet.getString("NAME"));
                driverCar.setSurname(resultSet.getString("SURNAME"));
                driverCar.setEstablishedPost(resultSet.getString("ESTABLISHED_POST"));
                driverCar.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH"));


                driverCars.add(driverCar);
            }
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }
        return driverCars;
    }


    @Override
    public void updateDriverCar(DriverCar driver) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("UPDATE drivers SET NAME = ?, SURNAME = ?, ESTABLISHED_POST = ?, " +
                    "DATE_OF_BIRTH = ? WHERE ID = ?");
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getSurname());
            preparedStatement.setString(3, driver.getEstablishedPost());
            preparedStatement.setString(4, String.valueOf(driver.getDateOfBirth()));
            preparedStatement.setLong(5, driver.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
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
    public void deleteDriverCarById(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("DELETE * FROM drivers WHERE ID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (Exception e) {

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
}

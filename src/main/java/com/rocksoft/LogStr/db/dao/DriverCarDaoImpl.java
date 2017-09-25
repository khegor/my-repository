package com.rocksoft.LogStr.db.dao;

import com.rocksoft.LogStr.db.models.Address;
import com.rocksoft.LogStr.db.models.DriverCar;

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

        PreparedStatement preparedStatement = getPreparedStatement("INSERT INTO addresses (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH) VALUES (?, ?, ?, ?)");
        try {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getSurname());
            preparedStatement.setString(3, driver.getEstablishedPost());
            preparedStatement.setString(4, String.valueOf(driver.getDateOfBirth()));

            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
            closeConnection();
        }
    }


    @Override
    public DriverCar getDriverCarById(long id) {

        PreparedStatement preparedStatement = getPreparedStatement("SELECT * FROM drivers WHERE ID = ?");
        DriverCar driverCar = null;
        try {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            driverCar = new DriverCar();

            driverCar.setId(resultSet.getLong("ID"));
            driverCar.setName(resultSet.getString("NAME"));
            driverCar.setSurname(resultSet.getString("SURNAME"));
            driverCar.setEstablishedPost(resultSet.getString("ESTABLISHED_POST"));
            driverCar.setDateOfBirth(resultSet.getString("DATE_OF_BIRTH"));


        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection();
        }
        return driverCar;
    }

    @Override
    public List<DriverCar> getAllDriverCar() {

        PreparedStatement preparedStatement = getPreparedStatement("SELECT * FROM drivers");
        DriverCar driverCar = null;
        List<DriverCar> driverCars = new ArrayList<>();

        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                driverCar = new DriverCar();
                driverCar.setId(resultSet.getLong("ID"));
                driverCar.setName(resultSet.getString("NAME"));
                driverCar.setSurname(resultSet.getString("SURNAME"));
                driverCar.setEstablishedPost(resultSet.getString("ESTABLISHED_POST"));
                driverCar.setDateOfBirth(resultSet.getString("DATE_OF_BIRTH"));

                driverCars.add(driverCar);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection();
        }
        return driverCars;
    }


    @Override
    public void updateDriverCar(DriverCar driver) {

        PreparedStatement preparedStatement = getPreparedStatement("UPDATE drivers SET NAME = ?, SURNAME = ?, ESTABLISHED_POST = ?, DATE_OF_BIRTH = ? WHERE ID = ?");

        try {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getSurname());
            preparedStatement.setString(3, driver.getEstablishedPost());
            preparedStatement.setString(4, String.valueOf(driver.getDateOfBirth()));
            preparedStatement.setLong(5, driver.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection();
        }
    }

    @Override
    public void deleteDriverCarById(long id) {

        PreparedStatement preparedStatement = getPreparedStatement("DELETE FROM drivers WHERE ID = ?");

        try {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {

            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection();
        }

    }
}

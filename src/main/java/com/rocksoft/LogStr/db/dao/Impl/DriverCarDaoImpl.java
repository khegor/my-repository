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
            preparedStatement = connection.prepareStatement("INSERT INTO drivers (NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH, ADDRESSES_ID) VALUES (?, ?, ?, ?, ?)");

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

        Car car = null;
        DriverCar driverCar = null;
        List<Car> cars = new ArrayList<>();
        ResultSet resultSet = null;
        Address address = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT D.ID, D.NAME, D.SURNAME, D.ESTABLISHED_POST, D.DATE_OF_BIRTH, " +
                    "DC.CAR_MODEL, DC.NUMBER, A.COUNTRY, A.CITY, A.STREET, A.HOME_NUMBER, DC.CAR_MODEL, DC.NUMBER FROM DRIVERS D JOIN DRIVER_HAS_DRIVERS_CARS DHDC " +
                    "ON D.ID = DHDC.DRIVER_ID JOIN DRIVERS_CARS DC ON DHDC.DRIVERS_CARS_ID = DC.ID \n" +
                    "JOIN ADDRESSES A ON D.ADDRESSES_ID = A.ID WHERE D.ID = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            driverCar = new DriverCar();
            address = new Address();

                driverCar.setId(resultSet.getLong("ID"));
                driverCar.setName(resultSet.getString("NAME"));
                driverCar.setSurname(resultSet.getString("SURNAME"));
                driverCar.setEstablishedPost(resultSet.getString("ESTABLISHED_POST"));
                driverCar.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH"));

                address.setCountry(resultSet.getString("COUNTRY"));
                address.setCity(resultSet.getString("CITY"));
                address.setStreet(resultSet.getString("STREET"));
                address.setHomeNumber(resultSet.getString("HOME_NUMBER"));
                driverCar.setAddress(address);

                resultSet.previous();
                while (resultSet.next()) {
                    car = new Car();
                    car.setId(resultSet.getLong("ID"));
                    car.setCarModel(resultSet.getString("CAR_MODEL"));
                    car.setNumber(resultSet.getString("NUMBER"));
                    cars.add(car);
                }

            driverCar.setCars(cars);

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
        Address address = null;
        List<DriverCar> driverCars = new ArrayList<>();
        List<Car> cars = null;
        Car car = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT D.ID, D.NAME, D.SURNAME, D.ESTABLISHED_POST, D.DATE_OF_BIRTH, " +
                    "A.COUNTRY, A.CITY, A.STREET, A.HOME_NUMBER, DC.CAR_MODEL, DC.NUMBER FROM drivers D JOIN driver_has_drivers_cars " +
                    "DHDC ON D.ID = DHDC.DRIVER_ID JOIN drivers_cars DC ON DHDC.DRIVERS_CARS_ID = DC.ID JOIN addresses A ON A.ID = D.ADDRESSES_ID;");

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                driverCar = new DriverCar();
                cars = new ArrayList<>();
                address = new Address();
                driverCar.setId(resultSet.getLong("ID"));
                driverCar.setName(resultSet.getString("NAME"));
                driverCar.setSurname(resultSet.getString("SURNAME"));
                driverCar.setEstablishedPost(resultSet.getString("ESTABLISHED_POST"));
                driverCar.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH"));

                address.setCountry(resultSet.getString("COUNTRY"));
                address.setCountry(resultSet.getString("CITY"));
                address.setCountry(resultSet.getString("STREET"));
                address.setCountry(resultSet.getString("HOME_NUMBER"));

                driverCar.setAddress(address);

                resultSet.previous();
                while(resultSet.next() && driverCar.getId() == resultSet.getLong("ID")) {
                    car = new Car();
                    car.setCarModel(resultSet.getString("CAR_MODEL"));
                    car.setNumber(resultSet.getString("NUMBER"));
                    cars.add(car);
                }
                resultSet.previous();
                driverCar.setCars(cars);
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
            preparedStatement = connection.prepareStatement("UPDATE drivers SET NAME = ?, SURNAME = ?, ESTABLISHED_POST = ?, DATE_OF_BIRTH = ? WHERE ID = ?");
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
            preparedStatement = connection.prepareStatement("DELETE FROM drivers WHERE ID = ?");
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

package com.rocksoft.LogStr.db.dao.daoImpl;


import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.daoInterf.CarDao;
import com.rocksoft.LogStr.db.models.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Esenin on 27.09.2017.
 */
public class CarDaoImpl extends AbstarctDao implements CarDao {


    @Override
    public void createCar(Car cars) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO drivers_cars (CAR_MODEL, NUMBER) VALUES (?, ?)");
            preparedStatement.setString(1, "CAR_MODEL");
            preparedStatement.setString(2, "NUMBER");

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

    @Override
    public Car getCarById(long id) {

        /*Car car = null;
        DriverCar driverCar = null;
        List<Car> cars = new ArrayList<>();
        ResultSet resultSet = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT D.ID, D.SURNAME, DC.CAR_MODEL, DC.NUMBER FROM DRIVERS D JOIN DRIVER_HAS_DRIVERS_CARS DHDC ON D.ID = DHDC.DRIVER_ID JOIN DRIVERS_CARS DC ON DHDC.DRIVERS_CARS_ID = DC.ID WHERE D.ID = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            driverCar = new DriverCar();
            driverCar.setId(resultSet.getLong("ID"));
            driverCar.setSurname(resultSet.getString("SURNAME"));
            resultSet.previous();
            while(resultSet.next()) {
                car = new Car();
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
                e.printStackTrace();
            }
            closeConnection(connection);
        }


*/
        return null;
    }

    @Override
    public void updateDriversCars(Car cars) {

    }

    @Override
    public void deleteDriversCars(long id) {

    }
}

package com.rocksoft.LogStr.db.servces;

import com.rocksoft.LogStr.db.dao.DriverCarDao;
import com.rocksoft.LogStr.db.dao.DriverCarDaoImpl;
import com.rocksoft.LogStr.db.models.DriverCar;

import java.util.List;

/**
 * Created by Esenin on 25.09.2017.
 */
public class DriverCarService {

    private DriverCarDao driverCarDao = new DriverCarDaoImpl();

    public void createDriverCar(DriverCar driver) {
        driverCarDao.createDriverCar(driver);
    }

    public DriverCar getDriverCarById(long id) {
        return driverCarDao.getDriverCarById(id);
    }

    public List<DriverCar> getAllAddresses() {
        return driverCarDao.getAllDriverCar();
    }

    public void updateDriverCar(DriverCar driver) {
        driverCarDao.updateDriverCar(driver);
    }

    public void deleteDriverCar(long id) {
        driverCarDao.deleteDriverCarById(id);
    }
}

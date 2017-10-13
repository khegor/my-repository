package com.rocksoft.LogStr.db.servces;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.AddressDao;
import com.rocksoft.LogStr.db.dao.DriverCarDao;
import com.rocksoft.LogStr.db.dao.Impl.AddressDaoImpl;
import com.rocksoft.LogStr.db.dao.Impl.DriverCarDaoImpl;
import com.rocksoft.LogStr.db.models.Address;
import com.rocksoft.LogStr.db.models.DriverCar;

import java.util.List;

/**
 * Created by Esenin on 25.09.2017.
 */
public class DriverCarService {


    private DriverCarDao driverCarDao = new DriverCarDaoImpl();
    private AddressDao addressDao = new AddressDaoImpl();

    public void createDriverCar(DriverCar driver) {
        addressDao.createAddress(driver.getAddress());
        driverCarDao.createDriverCar(driver);
    }

    public DriverCar getDriverCarById(long id) {
        DriverCar driverCar = driverCarDao.getDriverCarById(id);
        driverCar.setAddress(addressDao.getAddressById(id));
        return driverCar;
    }

    public List<DriverCar> getAllDriverCars() {
        addressDao.getAllAddresses();
        driverCarDao.getAllDriverCar();
        return driverCarDao.getAllDriverCar();
    }

    public void updateDriverCar(DriverCar driver, Address address) {
        addressDao.updateAddress(address);
        driverCarDao.updateDriverCar(driver);
    }

    public void deleteDriverCar(long id) {
        addressDao.deleteAddressById(id);
        driverCarDao.deleteDriverCarById(id);
    }
}

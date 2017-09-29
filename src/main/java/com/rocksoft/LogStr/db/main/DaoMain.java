package com.rocksoft.LogStr.db.main;

import com.rocksoft.LogStr.db.dao.daoImpl.CarDaoImpl;
import com.rocksoft.LogStr.db.servces.DirectorService;
import com.rocksoft.LogStr.db.servces.DriverCarService;
import org.apache.log4j.BasicConfigurator;

/**
 * Created by Esenin on 24.09.2017.
 */
public class DaoMain {

    public static void main(String[] args) {
        BasicConfigurator.configure();

        /*AddressService addressService = new AddressService();
        Address address = addressService.getAddressById(1);
        List<Address> addresses = addressService.getAllAddresses();
        System.out.println(address);*/

//        DriverCarService driverCarService = new DriverCarService();
//        DriverCar driverCar = driverCarService.getDriverCarById(1);
//        List<DriverCar> driverCars = driverCarService.getAllDriverCars();
//        System.out.println(driverCar);
        DirectorService directorService = new DirectorService();
        DriverCarService driverCarService = new DriverCarService();
        driverCarService.getAllDriverCars();
        CarDaoImpl carDao = new CarDaoImpl();
        carDao.getCarById(1);

        /*for(int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Director director = directorService.getDirectorById(1);
                    System.out.println(director);
                }
            }).start();
        }*/

        directorService.closeAll();
    }
}

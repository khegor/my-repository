package com.rocksoft.LogStr.db.main;


import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.AddressDao;
import com.rocksoft.LogStr.db.dao.Impl.AddressDaoImpl;
import com.rocksoft.LogStr.db.models.*;
import com.rocksoft.LogStr.db.servces.AddressService;
import com.rocksoft.LogStr.db.servces.DirectorService;
import com.rocksoft.LogStr.db.servces.DriverCarService;
import com.rocksoft.LogStr.db.servces.OrdersService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Esenin on 24.09.2017.
 */
public class DaoMain {

    public static final Logger LOGGER = Logger.getLogger(DaoMain.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();


//                                                         GetDriverByID
// _____________________________________________________________________________________________________________________
//        DriverCarService driverCarService = new DriverCarService();
//        DriverCar driverCar = driverCarService.getDriverCarById(1);
//        System.out.println(driverCar);


//                                                          CreateDriver
//______________________________________________________________________________________________________________________
//        DriverCarService driverCarService = new DriverCarService();
//        Address address = new Address();
//        address.setCountry("RUS");
//        address.setCity("Moskow");
//        address.setStreet("Mira");
//        address.setHomeNumber("19");
//
//        DriverCar driverCar1 = new DriverCar();
//        driverCar1.setAddress(address);
//        driverCar1.setName("Serafim");
//        driverCar1.setSurname("Petrou");
//        driverCar1.setEstablishedPost("driver");
//        try {
//            driverCar1.setDateOfBirth(new Timestamp(new SimpleDateFormat("yyyy-mm-dd").parse("1992-02-02").getTime()));
//
//        } catch (ParseException e) {
//            LOGGER.error(e);
//        }
//        driverCar1.setAddress(address);
//        driverCarService.createDriverCar(driverCar1);



//                                                      DeleteDrivers
//______________________________________________________________________________________________________________________

//        DriverCarService driverCarService = new DriverCarService();
//        driverCarService.deleteDriverCar(1);



//                                                        UpdateDrivers
//______________________________________________________________________________________________________________________


//        DriverCarService driverCarService = new DriverCarService();
//        AddressService addressService = new AddressService();
//        DriverCar driverCar = driverCarService.getDriverCarById(2);
//        Address address = addressService.getAddressById(driverCar.getId());
//        driverCar.setName("Viktor");
//        address.setCountry("PLN");
//        address.setCity("Warsowie");
//        address.setStreet("Gusouskogo");
//        driverCarService.updateDriverCar(driverCar, address);
//        System.out.println(driverCar.getName() + " " + driverCar.getAddress());



//                                                    GetAllDrivers
//______________________________________________________________________________________________________________________


//        DriverCarService driverCarService = new DriverCarService();
//        List<DriverCar> driverCars = driverCarService.getAllDriverCars();
//        for (DriverCar dc : driverCars){
//            System.out.println(dc);
//        }

    }
}

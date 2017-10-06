package com.rocksoft.LogStr.db.main;


import com.rocksoft.LogStr.db.models.*;
import com.rocksoft.LogStr.db.servces.DirectorService;
import com.rocksoft.LogStr.db.servces.DriverCarService;
import com.rocksoft.LogStr.db.servces.OrdersService;
import org.apache.log4j.BasicConfigurator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Esenin on 24.09.2017.
 */
public class DaoMain {

    public static void main(String[] args) {
        BasicConfigurator.configure();


        /*DirectorService directorService = new DirectorService();
        Director director = directorService.getDirectorById(1);
        System.out.println(director);*/

        /*DriverCarService driverCarService = new DriverCarService();
        DriverCar driverCar = driverCarService.getDriverCarById(4);
        System.out.println(driverCar);*/

        DriverCarService driverCarService = new DriverCarService();
        DriverCar driverCar = new DriverCar();
        for(DriverCar dc : driverCarService.getAllDriverCars()){
            System.out.println(dc);
        }

        List<DriverCar> driverCars = driverCarService.getAllDriverCars();
        DriverCar driverCar1 = driverCars.get(1);
        driverCar1.setName("Dodo");
        driverCarService.updateDriverCar(driverCar1);
        driverCarService.deleteDriverCar(6);
        System.out.println(driverCar1.getName());



    }
}

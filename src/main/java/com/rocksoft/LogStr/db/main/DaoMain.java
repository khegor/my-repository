package com.rocksoft.LogStr.db.main;


import com.rocksoft.LogStr.db.models.Director;
import com.rocksoft.LogStr.db.models.DriverCar;
import com.rocksoft.LogStr.db.models.Orders;
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


        DirectorService directorService = new DirectorService();
        Director director = directorService.getDirectorById(1);
        System.out.println(director);

        DriverCarService driverCarService = new DriverCarService();
        DriverCar driverCar = driverCarService.getDriverCarById(1);
        System.out.println(driverCar);

    }
}

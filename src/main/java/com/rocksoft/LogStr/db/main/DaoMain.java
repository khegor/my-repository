package com.rocksoft.LogStr.db.main;


        import com.rocksoft.LogStr.db.dao.AbstarctDao;
        import com.rocksoft.LogStr.db.dao.AddressDao;
        import com.rocksoft.LogStr.db.dao.Impl.AddressDaoImpl;
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

        DriverCarService driverCarService = null;



        /*DirectorService directorService = new DirectorService();
        Director director = directorService.getDirectorById(1);
        System.out.println(director);*/

        /*DriverCarService driverCarService = new DriverCarService();
        DriverCar driverCar = driverCarService.getDriverCarById(4);
        System.out.println(driverCar);*/

//        DriverCarService driverCarService = new DriverCarService();
//        DriverCar driverCar = new DriverCar();
//        for(DriverCar dc : driverCarService.getAllDriverCars()){
//            System.out.println(dc);
//        }
//
//        List<DriverCar> driverCars = driverCarService.getAllDriverCars();
//        DriverCar driverCar1 = driverCars.get(1);
//        driverCar1.setName("Dodo");
//        driverCarService.updateDriverCar(driverCar1);
//        driverCarService.deleteDriverCar(6);
//        System.out.println(driverCar1.getName());


//        driverCarService = new DriverCarService();
//        DriverCar driverCar = driverCarService.getDriverCarById(1);
//        System.out.println(driverCar);

        Address address = new Address();
        address.setCountry("RUS");
        address.setCity("Moskow");
        address.setStreet("Mira");
        address.setHomeNumber("19");

        DriverCar driverCar1 = new DriverCar();
        driverCar1.setAddress(address);
        driverCar1.setName("Serafim");
        driverCar1.setSurname("Petrou");
        driverCar1.setEstablishedPost("driver");
        driverCar1.setDateOfBirth("1998-01-01");
        driverCar1.setId(address.getId());

        driverCarService.createDriverCar(driverCar1, address);




    }
}

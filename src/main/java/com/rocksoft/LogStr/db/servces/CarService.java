package com.rocksoft.LogStr.db.servces;

import com.rocksoft.LogStr.db.dao.Impl.CarDaoImpl;
import com.rocksoft.LogStr.db.models.Car;

import java.util.List;

/**
 * Created by Esenin on 29.09.2017.
 */
public class CarService {

    CarDaoImpl carDao = new CarDaoImpl();

    public void createCar(Car cars){
        carDao.createCar(cars);
    }

    public Car getCarById(long id){
        return carDao.getCarById(id);
    }

    public List<Car> getAllCars(){
        return carDao.getAllCars();
    }

    public void updateDriversCars(Car cars){
        carDao.updateDriversCars(cars);
    }

    public void deleteDriversCars(long id){
        carDao.deleteDriversCars(id);
    }

    public  void closeAll(){
        carDao.closeAllConns();
    }
}

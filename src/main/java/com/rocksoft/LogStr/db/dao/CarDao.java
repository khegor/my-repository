package com.rocksoft.LogStr.db.dao;

import com.rocksoft.LogStr.db.models.Car;

import java.util.List;

/**
 * Created by Esenin on 27.09.2017.
 */
public interface CarDao {

    void createCar(Car cars);
    Car getCarById(long id);
    List <Car> getAllCars();
    void updateDriversCars(Car cars);
    void deleteDriversCars(long id);
}

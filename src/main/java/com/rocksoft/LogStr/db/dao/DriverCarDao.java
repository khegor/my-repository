package com.rocksoft.LogStr.db.dao;

import com.rocksoft.LogStr.db.models.DriverCar;

import java.util.List;

/**
 * Created by Esenin on 25.09.2017.
 */
public interface DriverCarDao {

    void createDriverCar(DriverCar driver);
    DriverCar getDriverCarById(long id);
    List<DriverCar> getAllDriverCar();
    void updateDriverCar(DriverCar driver);
    void deleteDriverCarById(long id);
}

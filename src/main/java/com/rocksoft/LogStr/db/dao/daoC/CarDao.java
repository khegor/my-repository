package com.rocksoft.LogStr.db.dao.daoC;

import com.rocksoft.LogStr.db.models.Car;

/**
 * Created by Esenin on 27.09.2017.
 */
public interface CarDao {

    void createCar(Car cars);
    Car getCarById(long id);
    void updateDriversCars(Car cars);
    void deleteDriversCars(long id);
}

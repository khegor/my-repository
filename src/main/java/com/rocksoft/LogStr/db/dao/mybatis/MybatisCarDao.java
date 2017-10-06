package com.rocksoft.LogStr.db.dao.mybatis;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.CarDao;
import com.rocksoft.LogStr.db.models.Car;

import java.util.List;

/**
 * Created by Esenin on 06.10.2017.
 */
public class MybatisCarDao extends AbstarctDao implements CarDao {
    @Override
    public void createCar(Car cars) {

    }

    @Override
    public Car getCarById(long id) {
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        return null;
    }

    @Override
    public void updateDriversCars(Car cars) {

    }

    @Override
    public void deleteDriversCars(long id) {

    }
}

package com.rocksoft.LogStr.db.main;

import com.rocksoft.LogStr.db.dao.mybatis.MybatisDriverCarDao;
import com.rocksoft.LogStr.db.models.DriverCar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Esenin on 06.10.2017.
 */
public class MybatisMain {

    public static void main(String[] args) {

        DriverCar driverCar = new DriverCar();
        MybatisDriverCarDao mybatisDriverCarDao = new MybatisDriverCarDao();
        driverCar = mybatisDriverCarDao.getDriverCarById(1);
        System.out.println(driverCar.getName() + " " + driverCar.getSurname());

    }
}

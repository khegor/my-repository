package com.rocksoft.LogStr.db.dao.mybatis;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.DriverCarDao;
import com.rocksoft.LogStr.db.models.DriverCar;
import com.rocksoft.LogStr.db.models.SessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Esenin on 06.10.2017.
 */
public class MybatisDriverCarDao extends AbstarctDao implements DriverCarDao{


    @Override
    public void createDriverCar(DriverCar driver) {

        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert("driverCarMapping.createDriverCar", driver);
        sqlSession.close();
    }

    @Override
    public DriverCar getDriverCarById(long id) {

        SqlSession sqlSession = SessionFactory.getSession();
        DriverCar driverCar = sqlSession.selectOne("driverCarMapping.getDriverCarById", id);
        sqlSession.close();
        return driverCar;
    }

    @Override
    public List<DriverCar> getAllDriverCar() {

        SqlSession sqlSession = SessionFactory.getSession();
        List<DriverCar> drivers = sqlSession.selectList("driverCarMapping.getAllDriverCar");
        sqlSession.close();
        return drivers;
    }

    @Override
    public void updateDriverCar(DriverCar driver) {

        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.update("driverCarMapping.updateDriverCar", driver);
        sqlSession.close();
    }

    @Override
    public void deleteDriverCarById(long id) {

        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.delete("driverCarMapping.deleteDriverCarByID", id);
        sqlSession.close();
    }
}

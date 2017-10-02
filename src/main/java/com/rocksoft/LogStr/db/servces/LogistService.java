package com.rocksoft.LogStr.db.servces;

import com.rocksoft.LogStr.db.dao.daoImpl.LogistDaoImpl;
import com.rocksoft.LogStr.db.models.Logist;

/**
 * Created by Esenin on 29.09.2017.
 */
public class LogistService {

    LogistDaoImpl logistDao = new LogistDaoImpl();


    public void createLogist(Logist logist){
        logistDao.createLogist(logist);
    }


    public Logist getLogistById(long id){
        return logistDao.getLogistById(id);
    }


    public void updateLogist(Logist logist){
       logistDao.updateLogist(logist);
    }


    public void deleteDirectorById(long id){
        logistDao.deleteLogistById(id);
    }

    public void closeAll(){
        logistDao.closeAllConns();
    }
}

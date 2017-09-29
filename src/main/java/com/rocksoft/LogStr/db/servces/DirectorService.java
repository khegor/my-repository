package com.rocksoft.LogStr.db.servces;

import com.rocksoft.LogStr.db.dao.daoImpl.DirectorDaoImpl;
import com.rocksoft.LogStr.db.models.Director;

/**
 * Created by Esenin on 26.09.2017.
 */
public class DirectorService{


    DirectorDaoImpl directorDao = new DirectorDaoImpl();


    public void createDirector(Director director){
        directorDao.createDirector(director);
    }


    public Director getDirectorById(long id){
        return directorDao.getDirectorById(id);
    }


    public void updateDirector(Director director){
        directorDao.updateDirector(director);
    }


    public void deleteDirectorById(long id){
        directorDao.deleteDirectorById(id);
    }

    public void closeAll(){
        directorDao.closeAllConns();
    }
}

package com.rocksoft.LogStr.db.servces;

import com.rocksoft.LogStr.db.dao.daoImpl.StorekeeperDaoImpl;
import com.rocksoft.LogStr.db.models.Storekeeper;

/**
 * Created by Esenin on 29.09.2017.
 */
public class StorekeeperService {


    StorekeeperDaoImpl storekeeperDao = new StorekeeperDaoImpl();


    public void createStorekeeper(Storekeeper storekeeper){
        storekeeperDao.createStorekeeper(storekeeper);
    }


    public Storekeeper getStorekeeperById(long id){
        return storekeeperDao.getStorekeeperById(id);
    }


    public void updateStorekeeper(Storekeeper storekeeper){
        storekeeperDao.updateStorekeeper(storekeeper);
    }


    public void deleteStorekeeperById(long id){
        storekeeperDao.deleteStorekeeperById(id);
    }

    public void closeAll(){
        storekeeperDao.closeAllConns();
    }
}

package com.rocksoft.LogStr.db.servces;

import com.rocksoft.LogStr.db.dao.AddressDao;
import com.rocksoft.LogStr.db.dao.Impl.AddressDaoImpl;
import com.rocksoft.LogStr.db.dao.Impl.DirectorDaoImpl;
import com.rocksoft.LogStr.db.models.Address;
import com.rocksoft.LogStr.db.models.Director;

/**
 * Created by Esenin on 26.09.2017.
 */
public class DirectorService{


    DirectorDaoImpl directorDao = new DirectorDaoImpl();
    private AddressDao addressDao = new AddressDaoImpl();


    public void createDirector(Director director){
        addressDao.createAddress(director.getAddress());
        directorDao.createDirector(director);
    }


    public Director getDirectorById(long id){
        Director director = directorDao.getDirectorById(id);
        director.setAddress(addressDao.getAddressById(id));
        return director;
    }


    public void updateDirector(Director director, Address address){
        directorDao.updateDirector(director);
        addressDao.updateAddress(address);
    }


    public void deleteDirectorById(long id){
        addressDao.deleteAddressById(id);
        directorDao.deleteDirectorById(id);
    }

    public void closeAll(){
        directorDao.closeAllConns();
    }
}

package com.rocksoft.LogStr.db.servces;

import com.rocksoft.LogStr.db.models.Address;
import com.rocksoft.LogStr.db.dao.AddressDao;
import com.rocksoft.LogStr.db.dao.AddressDaoImpl;
import java.util.List;

/**
 * Created by Esenin on 24.09.2017.
 */
public class AddressService {

    private AddressDao addressDao = new AddressDaoImpl();

    public void createAddress(Address address) {
        addressDao.createAddress(address);
    }

    public Address getAddressById(long id) {
        return addressDao.getAddressById(id);
    }

    public List<Address> getAllAddresses() {
        return addressDao.getAllAddresses();
    }

    public void updateAddress(Address address) {
        addressDao.updateAddress(address);
    }

    public void deleteAddressById(long id) {
        addressDao.deleteAddressById(id);
    }
}

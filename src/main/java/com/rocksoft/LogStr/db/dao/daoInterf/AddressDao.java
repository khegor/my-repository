package com.rocksoft.LogStr.db.dao.daoInterf;

import com.rocksoft.LogStr.db.models.Address;

import java.util.List;

/**
 * Created by Esenin on 24.09.2017.
 */
public interface AddressDao {
    void createAddress(Address address);
    Address getAddressById(long id);
    List<Address> getAllAddresses();
    void updateAddress(Address address);
    void deleteAddressById(long id);
}

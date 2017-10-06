package com.rocksoft.LogStr.db.dao.mybatis;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.AddressDao;
import com.rocksoft.LogStr.db.models.Address;

import java.util.List;

/**
 * Created by Esenin on 06.10.2017.
 */
public class MybatisAddressDao extends AbstarctDao implements AddressDao{
    @Override
    public void createAddress(Address address) {

    }

    @Override
    public Address getAddressById(long id) {
        return null;
    }

    @Override
    public List<Address> getAllAddresses() {
        return null;
    }

    @Override
    public void updateAddress(Address address) {

    }

    @Override
    public void deleteAddressById(long id) {

    }
}

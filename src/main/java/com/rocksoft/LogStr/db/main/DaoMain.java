package com.rocksoft.LogStr.db.main;

import com.rocksoft.LogStr.db.models.Address;
import com.rocksoft.LogStr.db.servces.AddressService;
import org.apache.log4j.BasicConfigurator;

import java.util.List;

/**
 * Created by Esenin on 24.09.2017.
 */
public class DaoMain {

    public static void main(String[] args) {
        BasicConfigurator.configure();

        AddressService addressService = new AddressService();
        Address address = addressService.getAddressById(1);
        List<Address> addresses = addressService.getAllAddresses();
        System.out.println(address);
    }
}

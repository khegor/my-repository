package com.rocksoft.LogStr.db.dao.daoImpl;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.daoInterf.OrdersDao;
import com.rocksoft.LogStr.db.models.Orders;

/**
 * Created by Esenin on 29.09.2017.
 */
public class OrdersDaoImpl extends AbstarctDao implements OrdersDao {


    @Override
    public void createOrder(Orders order) {

    }

    @Override
    public Orders getOrdersById(long id) {
        return null;
    }

    @Override
    public void updateOrders(Orders orders) {

    }

    @Override
    public void deleteStorekeeperById(long id) {

    }
}

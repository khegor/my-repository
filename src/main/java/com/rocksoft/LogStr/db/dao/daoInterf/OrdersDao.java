package com.rocksoft.LogStr.db.dao.daoInterf;

import com.rocksoft.LogStr.db.models.Orders;

/**
 * Created by Esenin on 29.09.2017.
 */
public interface OrdersDao {

    void createOrder(Orders order);
    Orders getOrdersById(long id);
    void updateOrders(Orders orders);
    void deleteStorekeeperById(long id);
}

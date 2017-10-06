package com.rocksoft.LogStr.db.dao;

import com.rocksoft.LogStr.db.models.Orders;

import java.util.List;

/**
 * Created by Esenin on 29.09.2017.
 */
public interface OrdersDao {

    void createOrder(Orders order);
    List<Orders> getAllOrders();
    Orders getOrdersById(long id);
    void updateOrders(Orders orders);
    void deleteOrdersById(long id);
}

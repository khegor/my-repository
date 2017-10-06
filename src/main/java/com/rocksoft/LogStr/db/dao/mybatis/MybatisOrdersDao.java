package com.rocksoft.LogStr.db.dao.mybatis;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.OrdersDao;
import com.rocksoft.LogStr.db.models.Orders;

import java.util.List;

/**
 * Created by Esenin on 06.10.2017.
 */
public class MybatisOrdersDao extends AbstarctDao implements OrdersDao {
    @Override
    public void createOrder(Orders order) {

    }

    @Override
    public List<Orders> getAllOrders() {
        return null;
    }

    @Override
    public Orders getOrdersById(long id) {
        return null;
    }

    @Override
    public void updateOrders(Orders orders) {

    }

    @Override
    public void deleteOrdersById(long id) {

    }
}

package com.rocksoft.LogStr.db.servces;

import com.rocksoft.LogStr.db.dao.Impl.OrdersDaoImpl;
import com.rocksoft.LogStr.db.models.Orders;

import java.util.List;

/**
 * Created by Esenin on 29.09.2017.
 */
public class OrdersService {

    OrdersDaoImpl ordersDao = new OrdersDaoImpl();

        public void createOrder(Orders orders) {
            ordersDao.createOrder(orders);
        }


        public List<Orders> getAllOrders() {
            return ordersDao.getAllOrders();
        }


        public Orders getOrdersById(long id) {
            return ordersDao.getOrdersById(id);
        }


        public void updateOrders(Orders orders) {
            ordersDao.updateOrders(orders);
        }


        public void deleteOrdersById(long id) {
            ordersDao.deleteOrdersById(id);
        }

}


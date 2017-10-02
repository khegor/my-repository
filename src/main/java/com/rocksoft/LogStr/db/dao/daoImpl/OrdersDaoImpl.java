package com.rocksoft.LogStr.db.dao.daoImpl;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.daoInterf.OrdersDao;
import com.rocksoft.LogStr.db.models.Logist;
import com.rocksoft.LogStr.db.models.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Esenin on 29.09.2017.
 */
public class OrdersDaoImpl extends AbstarctDao implements OrdersDao {


    @Override
    public void createOrder(Orders order) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO orders (OWNER_ORGANISATION_NAME, OWNERSHIP_TYPE, OPERATION_TYPE) " +
                    "VALUES (?, ?, ?)");
            preparedStatement.setString(1, "OWNER_ORGANISATION_NAME");
            preparedStatement.setString(2, "OWNERSHIP_TYPE");
            preparedStatement.setString(3, "OPERATION_TYPE");

            preparedStatement.execute();

        } catch (Exception e) {
            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }
    }

    @Override
    public List<Orders> getAllOrders() {
        Logist logist = null;
        Orders order = null;
        List<Orders> orders = new ArrayList<>();
        ResultSet resultSet = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM logists L LEFT JOIN orders O ON L.ID = O.LOGISTS_ID;");
            resultSet = preparedStatement.executeQuery();
            resultSet.next();


            logist = new Logist();
            logist.setName(resultSet.getString("NAME"));
            logist.setSurname(resultSet.getString("SURNAME"));
            logist.setEstablishedPost("ESTABLISHED_POST");
            logist.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH"));
            resultSet.previous();
            while(resultSet.next()) {
                order = new Orders();
                order.setId(resultSet.getLong("ID"));
                order.setOwnerOrganisationName(resultSet.getString("OWNER_ORGANISATION_NAME"));
                order.setOwnerOrganisationName(resultSet.getString("OWNERSHIP_TYPE"));
                order.setOwnerOrganisationName(resultSet.getString("OPERATION_TYPE"));
                orders.add(order);
            }
            logist.setOrders(orders);

        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
               LOGGER.error(e);
            }
            closeConnection(connection);
        }return orders;
    }


    @Override
    public Orders getOrdersById(long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Orders order = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM orders O WHERE O.ID = ?");

            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            order = new Orders();
            order.setId(resultSet.getLong("ID"));
            order.setOwnerOrganisationName(resultSet.getString("OWNER_ORGANISATION_NAME"));
            order.setOwnerShipType(resultSet.getString("OWNERSHIP_TYPE"));
            order.setOperationType(resultSet.getString("OPERATION_TYPE"));

        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }  return order;
    }


    @Override
    public void updateOrders(Orders orders) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("UPDATE orders SET OWNER_ORGANISATION_NAME = ?, OWNERSHIP_TYPE = ?, " +
                    "OPERATION_TYPE = ?, " +
                    "WHERE ID = ?");
            preparedStatement.setString(1, orders.getOwnerOrganisationName());
            preparedStatement.setString(2, orders.getOwnershipType());
            preparedStatement.setString(3, orders.getOperationType());
            preparedStatement.setLong(4, orders.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }
    }


    @Override
    public void deleteOrdersById(long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE ID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (Exception e) {

            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }
    }
}

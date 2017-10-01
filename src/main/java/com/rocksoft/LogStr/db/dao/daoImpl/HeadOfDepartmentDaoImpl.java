package com.rocksoft.LogStr.db.dao.daoImpl;

import com.rocksoft.LogStr.db.dao.AbstarctDao;
import com.rocksoft.LogStr.db.dao.daoInterf.HeadOfDepartmentDao;
import com.rocksoft.LogStr.db.models.Address;
import com.rocksoft.LogStr.db.models.HeadOfDepartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Esenin on 29.09.2017.
 */
public class HeadOfDepartmentDaoImpl extends AbstarctDao implements HeadOfDepartmentDao {


    @Override
    public void createHeadOfDepartment(HeadOfDepartment headOfDepartment) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO heads_of_departments " +
                    "(NAME, SURNAME, ESTABLISHED_POST, DATE_OF_BIRTH, ADDRESSES_ID) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, headOfDepartment.getName());
            preparedStatement.setString(2, headOfDepartment.getSurname());
            preparedStatement.setString(3, headOfDepartment.getEstablishedPost());
            preparedStatement.setString(4, String.valueOf(headOfDepartment.getDateOfBirth()));
            preparedStatement.setLong(5, headOfDepartment.getAddress().getId());
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeConnection(connection);
        }
    }


    @Override
    public HeadOfDepartment getHeadOfDepartmentById(long id) {

        Connection connection = null;
        HeadOfDepartment head = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Address address = null;

        try {
            connection = getConnection();

            preparedStatement = connection.prepareStatement("SELECT H.ID, H.SURNAME FROM heads_of_departments H JOIN ADDRESSES A ON H.ADDRESSES_ID = A.ID WHERE H.ID = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            head = new HeadOfDepartment();
            head.setId(resultSet.getLong("ID"));
            head.setName(resultSet.getString("NAME"));
            head.setName(resultSet.getString("SURNAME"));
            head.setName(resultSet.getString("ESTABLISHED_POST"));
            head.setName(resultSet.getString("DATE_OF_BIRTH"));
            resultSet.previous();

            address.setCountry(resultSet.getString("COUNTRY"));
            address.setCity(resultSet.getString("CITY"));
            address.setStreet(resultSet.getString("STREET"));
            address.setHomeNumber(resultSet.getString("HOME_NUMBER"));
            head.setAddress(address);

            preparedStatement.close();
            resultSet.close();

        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            closeConnection(connection);
        }return head;
    }



    @Override
    public void updateHeadOfDepartment(HeadOfDepartment headOfDepartment) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
        connection = getConnection();
        preparedStatement = connection.prepareStatement("UPDATE heads_of_departments SET NAME = ?, SURNAME = ?, ESTABLISHED_POST = ?, DATE_OF_BIRTH = ? " +
                "WHERE ID = ?");
            preparedStatement.setString(1, headOfDepartment.getName());
            preparedStatement.setString(2, headOfDepartment.getSurname());
            preparedStatement.setString(3, headOfDepartment.getEstablishedPost());
            preparedStatement.setString(4, String.valueOf(headOfDepartment.getDateOfBirth()));
            preparedStatement.setLong(5, headOfDepartment.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }
    }

    @Override
    public void deleteHeadOfDepartmentById(long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM heads_of_departments WHERE ID = ?");

            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }catch(Exception e){
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }
    }
}

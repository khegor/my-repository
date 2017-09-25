package com.rocksoft.LogStr.db.dao;

import com.rocksoft.LogStr.db.connection.Connection;
import com.rocksoft.LogStr.db.connection.ConnectionPool;
import com.rocksoft.LogStr.db.Utils;
import org.apache.log4j.Logger;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Esenin on 24.09.2017.
 */
public abstract class AbstarctDao {

    protected static final Logger LOGGER = Logger.getLogger(AbstarctDao.class);

    //private Connection connection = null;
    private java.sql.Connection connection = null;
    private volatile ConnectionPool connectionPool = ConnectionPool.getInstance(3);

    protected synchronized PreparedStatement getPreparedStatement(String sql){
        PreparedStatement preparedStatement = null;
        try {
            //connection = connectionPool.getConnection(DriverManager.getConnection(Utils.getConfig("url"), Utils.getConfig("username"), Utils.getConfig("password")));
            //preparedStatement = connection.getConnection().prepareStatement(sql);
            connection = DriverManager.getConnection(Utils.getConfig("url"), Utils.getConfig("username"), Utils.getConfig("password"));
            preparedStatement = connection.prepareStatement(sql);
        }catch(SQLException e){
            LOGGER.info(e);
        }
        return preparedStatement;
    }

    protected synchronized void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }
}

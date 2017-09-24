package com.rocksoft.LogStr;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Esenin on 21.09.2017.
 */
public class Connection implements AutoCloseable{

    private static final Logger LOGGER = Logger.getLogger(Connection.class);

    private java.sql.Connection dbConnection;
    private ConnectionPool connectionPool;

    public Connection(java.sql.Connection connection, ConnectionPool connectionPool){
        this.dbConnection = connection;
        this.connectionPool = connectionPool;
    }

    public java.sql.Connection getConnection(){
        return dbConnection;
    }
    public Statement createStatement() throws SQLException {
        return dbConnection.createStatement();
    }

    @Override
    public void close() throws SQLException {
        this.dbConnection.close();
        this.connectionPool.closeConnection(dbConnection);
    }

    public void doSmth() {
        System.out.println("Hui " + Thread.currentThread().getId());
    }
}

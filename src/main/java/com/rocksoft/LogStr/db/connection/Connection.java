package com.rocksoft.LogStr.db.connection;

import org.apache.log4j.Logger;

import java.sql.SQLException;

/**
 * Created by Esenin on 21.09.2017.
 */
public class Connection implements AutoCloseable{

    private static final Logger LOGGER = Logger.getLogger(Connection.class);

    private final Object lock = new Object();

    private java.sql.Connection dbConnection;
    private volatile ConnectionPool connectionPool;

    public Connection(java.sql.Connection connection, ConnectionPool connectionPool){
        this.dbConnection = connection;
        this.connectionPool = connectionPool;
    }

    public java.sql.Connection getConnection(){
        return dbConnection;
    }

    @Override
    public void close() throws SQLException {
        this.dbConnection.close();
        this.connectionPool.closeConnection(dbConnection);
    }

    public void doSmth() {
        System.out.println("Hello " + Thread.currentThread().getId());
    }
}

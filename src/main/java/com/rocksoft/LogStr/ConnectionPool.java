package com.rocksoft.LogStr;

import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Esenin on 29.08.2017.
 */
public class ConnectionPool {

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    private static ConnectionPool connectionPool;
    private volatile ArrayBlockingQueue<Connection> pool;
    private Integer poolSize;
    private volatile Integer connectionCount;

    private ConnectionPool(Integer poolSize) {
        this.pool = new ArrayBlockingQueue<>(poolSize);
        this.poolSize = poolSize;
        this.connectionCount = 0;
    }

    public synchronized void addConnection() {
        if (poolIsEmpty()) {
            pool.add(new Connection());
            LOGGER.info("Connection " + Thread.currentThread().getId() + " was created");
        }
    }

    public synchronized Connection getConnection() {
        Connection connection = null;
        if (pool != null && !pool.isEmpty()) {
            try {
                connection = pool.take();
                connectionCount++;
                LOGGER.info("Connection " + Thread.currentThread().getId() + " was took");
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        } else if (poolIsFull()) {
            getConnection();
        }
        return connection;
    }

    /**
     * return connection to pool
     */
    private void closeConnection(Connection connection) {
        try {
            connection.getConnection().close();
        }catch(SQLException e){
            LOGGER.error(e);
        }
        pool.add(new Connection());
        LOGGER.info("Connection " + Thread.currentThread().getId() + " was returned to pool");
    }

    public static ConnectionPool getInstance(Integer poolSize) {
        ConnectionPool localInstance = connectionPool;
        if (localInstance == null) {
            synchronized (ConnectionPool.class) {
                localInstance = connectionPool;
                if (localInstance == null) {
                    connectionPool = localInstance = new ConnectionPool(poolSize);
                }
            }
        }
        return localInstance;
    }

    private boolean poolIsEmpty() {
        return pool != null && pool.isEmpty() || pool != null && connectionCount < poolSize;
    }

    private boolean poolIsFull() {
        return pool != null && pool.isEmpty() && connectionCount.equals(poolSize);
    }

    public synchronized void doSmth() {
        addConnection();
        Connection connection = getConnection();
        LOGGER.info("Connection " + Thread.currentThread().getId() + " do smth");
        closeConnection(connection);
    }
}


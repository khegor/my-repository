package com.rocksoft.LogStr.db.connection;

import org.apache.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Esenin on 29.08.2017.
 */
public class ConnectionPool {

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    private static volatile ConnectionPool connectionPool;
    private volatile ArrayBlockingQueue<Connection> pool;
    private volatile Integer poolSize;
    private volatile Integer connectionCount;

    private ConnectionPool(Integer poolSize) {
        this.pool = new ArrayBlockingQueue<>(poolSize);
        this.poolSize = poolSize;
        this.connectionCount = 0;
    }

    public synchronized void addConnection(java.sql.Connection dbConnection) {
        if (poolIsEmpty()) {
            pool.add(new Connection(dbConnection, this));
            LOGGER.info("Connection " + Thread.currentThread().getId() + " was created");
        }
    }

    public synchronized Connection getConnection(java.sql.Connection dbConnection) {
        addConnection(dbConnection);
        Connection connection = null;

        if (poolIsFull()) {
            try {
                wait();
                LOGGER.info("Thread " + Thread.currentThread().getId() + " is waiting");
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }
        if (pool != null && !pool.isEmpty()) {
            try {
                connection = pool.take();
                connectionCount++;
                LOGGER.info("Connection " + Thread.currentThread().getId() + " was took");
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }
        return connection;
    }

    /**
     * return connection to pool
     */
    public synchronized void closeConnection(java.sql.Connection dbConnection) {
        pool.add(new Connection(dbConnection, this));
        LOGGER.info("Connection " + Thread.currentThread().getId() + " was returned to pool");
        notify();
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
        return pool != null && pool.isEmpty() && connectionCount < poolSize;
    }

    private boolean poolIsFull() {
        return pool != null && pool.isEmpty() && connectionCount.equals(poolSize);
    }

    /*public synchronized void doSmth() {
        addConnection();
        Connection connection = getConnection();
        LOGGER.info("Connection " + Thread.currentThread().getId() + " do smth");
        closeConnection(connection);
    }*/
}

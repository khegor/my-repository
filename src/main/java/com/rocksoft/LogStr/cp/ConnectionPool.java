package com.rocksoft.LogStr.cp;

import org.apache.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Esenin on 29.08.2017.
 */
public class ConnectionPool {

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    private static volatile ConnectionPool connectionPool;
    private volatile ArrayBlockingQueue<Connection> pool;
    private Integer poolSize;
    private volatile Integer connectionCount;

    private ConnectionPool(Integer poolSize) {
        this.pool = new ArrayBlockingQueue<>(poolSize);
        this.poolSize = poolSize;
        connectionCount = 0;
    }

    private synchronized void addAndTakeConnection() {
        addConnection();
        takeConnection();
    }

    public synchronized void addConnection() {
        if(poolIsEmpty()) {
            pool.add(new Connection());
            LOGGER.info("Connection " + Thread.currentThread().getId() + " was created");
        }
    }

    public synchronized void takeConnection() {
        if(pool != null && !pool.isEmpty()) {
            try {
                pool.take();
                connectionCount++;
                LOGGER.info("Connection " + Thread.currentThread().getId() + " was took");
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        } else if(poolIsFull()) {
            waitForConnection();
            takeConnection();
        }
    }

    private synchronized void waitForConnection() {
        while(poolIsFull()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }
    }

    private void returnConnectionToPool() {
        pool.add(new Connection());
        LOGGER.info("Connection " + Thread.currentThread().getId() + " was returned to pool");
    }

    private boolean poolIsEmpty() {
        return pool != null && pool.isEmpty() || pool != null && connectionCount < poolSize;
    }

    private boolean poolIsFull() {
        return pool != null && pool.isEmpty() && connectionCount.equals(poolSize);
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

    public void doSmth() {
        addAndTakeConnection();
        LOGGER.info("Connection " + Thread.currentThread().getId() + " do smth");
        returnConnectionToPool();
    }
}

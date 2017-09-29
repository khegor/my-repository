package com.rocksoft.LogStr.db.connection.for_db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Esenin on 27.09.2017.
 */
public class DbConnectionPool {

    private static DbConnectionPool connectionPool;

    private volatile BlockingQueue<Connection> pool;
    private Integer poolSize;
    private volatile Integer connectionCount;

    private DbConnectionPool(Integer poolSize) {
        this.pool = new ArrayBlockingQueue<>(poolSize);
        this.poolSize = poolSize;
        this.connectionCount = 0;
    }

    public Connection getConnection(String url, String username, String password) throws InterruptedException, SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        if(pool != null && pool.isEmpty() && connectionCount < poolSize) {
            pool.add(connection);
            connectionCount++;
        }
        return pool.take();
    }

    public void close(Connection connection) {
        if(pool != null) {
            pool.add(connection);
        }
    }

    public void closeAll() {
        for(Connection connection : pool) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static DbConnectionPool getInstance(Integer poolSize) {
        DbConnectionPool localInstance = connectionPool;
        if (localInstance == null) {
            synchronized (DbConnectionPool.class) {
                localInstance = connectionPool;
                if (localInstance == null) {
                    connectionPool = localInstance = new DbConnectionPool(poolSize);
                }
            }
        }
        return localInstance;
    }
}

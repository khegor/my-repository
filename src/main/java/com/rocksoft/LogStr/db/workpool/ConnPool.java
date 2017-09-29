package com.rocksoft.LogStr.db.workpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Esenin on 27.09.2017.
 */
public class ConnPool {

    private static ConnPool connectionPool;

    private volatile BlockingQueue<Conn> pool;
    private Integer poolSize;
    private Integer connectionCount;

    private ConnPool(Integer poolSize) {
        this.pool = new ArrayBlockingQueue<>(poolSize);
        this.poolSize = poolSize;
        this.connectionCount = 0;
    }

    public Conn getConnection() throws InterruptedException {
        Conn connection = new Conn();
        if(pool != null && pool.isEmpty() && connectionCount < poolSize) {
            pool.add(connection);
            connectionCount++;
        }
        return pool.take();
    }

    public void close(Conn connection) {
        if(pool != null) {
            pool.add(connection);
        }
    }

    public static ConnPool getInstance(Integer poolSize) {
        ConnPool localInstance = connectionPool;
        if (localInstance == null) {
            synchronized (ConnPool.class) {
                localInstance = connectionPool;
                if (localInstance == null) {
                    connectionPool = localInstance = new ConnPool(poolSize);
                }
            }
        }
        return localInstance;
    }
}

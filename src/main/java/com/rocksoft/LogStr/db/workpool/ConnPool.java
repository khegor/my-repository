package com.rocksoft.LogStr.db.workpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Esenin on 27.09.2017.
 */
public class ConnPool {

    private static ConnPool instance;

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
        if (pool != null && pool.isEmpty() && connectionCount < poolSize) {
            pool.add(connection);
            connectionCount++;
        }
        return pool.take();
    }

    public void close(Conn connection) {
        if (pool != null) {
            pool.add(connection);
        }
    }

    public static ConnPool getInstance(Integer poolSize) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            if (instance == null) {
                instance = new ConnPool(poolSize);
            }
            return instance;
        } finally {
            lock.unlock();
        }
    }
}


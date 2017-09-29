package com.rocksoft.LogStr.db.connection.cp;

/**
 * Created by Esenin on 27.09.2017.
 */
public class Conn {

    public void testConnection() {
        System.out.println(Thread.currentThread().getId() + " was started");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId() + " was finished");
    }
}

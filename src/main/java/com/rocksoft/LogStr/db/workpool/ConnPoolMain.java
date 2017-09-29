package com.rocksoft.LogStr.db.workpool;

/**
 * Created by Esenin on 27.09.2017.
 */
public class ConnPoolMain {

    public static void main (String[] args) {
        ConnPool connPool = ConnPool.getInstance(3);
        for(int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Conn conn = null;
                    try {
                        conn = connPool.getConnection();
                        conn.testConnection();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        connPool.close(conn);
                    }
                }
            }).start();
        }
    }
}

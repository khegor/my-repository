package com.rocksoft.LogStr.db.main.all;

import com.rocksoft.LogStr.db.connection.cp.Conn;
import com.rocksoft.LogStr.db.connection.cp.ConnPool;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


/**
 * Created by Esenin on 27.09.2017.
 */
public class ConnPoolMain {

    public static final Logger LOGGER = Logger.getLogger(ConnPoolMain.class);
    public static void main (String[] args) {
        BasicConfigurator.configure();
        ConnPool connPool = ConnPool.getInstance(3);
        for(int i = 0; i < 5; i++) {
            new Thread(() -> {
                    Conn conn = null;
                    try {
                        conn = connPool.getConnection();
                        conn.testConnection();
                    } catch (InterruptedException e) {
                        LOGGER.error(e);
                    } finally {
                        connPool.close(conn);
                    }
                }).start();
        }
    }
}

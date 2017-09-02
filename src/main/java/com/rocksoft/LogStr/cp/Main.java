package com.rocksoft.LogStr.cp;

import org.apache.log4j.BasicConfigurator;

/**
 * Created by Esenin on 29.08.2017.
 */
public class Main {

    public static void main(String args[]) {

        BasicConfigurator.configure();

       int connectionPoolSize = 3;
       int threadNumber = 5;

        ConnectionPool cp = ConnectionPool.getInstance(connectionPoolSize);
        for (int i = 0; i < threadNumber; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cp.doSmth();
                }
            }).start();
        }
    }
}



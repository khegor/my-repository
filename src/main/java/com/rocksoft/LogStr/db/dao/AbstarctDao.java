package com.rocksoft.LogStr.db.dao;

import com.rocksoft.LogStr.cp.ConnectionPool;
import com.rocksoft.LogStr.db.Utils;
import com.rocksoft.LogStr.db.connection.for_db.DbConnectionPool;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Esenin on 24.09.2017.
 */
public abstract class AbstarctDao {

    protected static final Logger LOGGER = Logger.getLogger(AbstarctDao.class);

    private static Properties properties;
    private static InputStream inputStream;
    private DbConnectionPool connectionPool = DbConnectionPool.getInstance(3);

    static {
        properties = new Properties();
        try {
            inputStream = new FileInputStream("src/main/resources/com/rocksoft/LogStr/config.properties");
            properties.load(inputStream);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                LOGGER.error(e);
            }
        }
    }

    private static String getConfig(String key) {
        return properties.getProperty(key);
    }

    public Connection getConnection() throws SQLException, InterruptedException {
        return connectionPool.getConnection(getConfig("url"), getConfig("username"), getConfig("password"));
    }

    public void closeConnection(Connection connection) {
        connectionPool.close(connection);
    }

    public void closeAllConns() {
        connectionPool.closeAll();
    }
}

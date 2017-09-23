package com.rocksoft.LogStr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Esenin on 21.09.2017.
 */
public class Connection {

    private java.sql.Connection dbConnection;

    public Connection(){
    }

    public Connection(java.sql.Connection connection){
        this.dbConnection = connection;
    }

    public java.sql.Connection getConnection(){
        return dbConnection;
    }
    public Statement createStatement() throws SQLException {
        return dbConnection.createStatement();
    }

    public void close() throws SQLException {
        this.dbConnection.close();
    }
}

package net.maromo.web05.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() throws ClassNotFoundException{
        final Connection conn;

        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/time", "root", "@Marc0608");

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return conn;
    }
}

package com.etc.DBUtill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class DBUtil {
    
    public static  Connection getConnetction() throws ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        String jdbUrl= "jdbc:mysql://localhost:3306/Intermediates";
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbUrl,"root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
        
    }
    public static void close(ResultSet rs ,PreparedStatement statement,Connection conn) {
        try {
            if(rs!=null){
                rs.close();
            }
            if(statement != null)
            {
                statement.close();;
            }
            if(conn !=null){
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void commit(Connection conn){
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void rollback(Connection conn){
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.etc.DBUtill.DBUtil;

public class LoginDao {

    public boolean login(String name, String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        boolean isAllow = false;
        try {
            conn = DBUtil.getConnetction();
            stmt = conn.prepareStatement("select * from login where name = '" + name + "' and password = '" + password + "'");
            rs = stmt.executeQuery();
            if(rs.next()) {
                isAllow = true;
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, stmt, conn);
        }
        return isAllow;
    }
}

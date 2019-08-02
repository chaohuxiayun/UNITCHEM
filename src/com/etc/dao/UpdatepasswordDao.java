package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.etc.DBUtill.DBUtil;

public class UpdatepasswordDao {

    public boolean update(String name, String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs = 0;        
        boolean isAllow = false;
        try {
            conn = DBUtil.getConnetction();
            stmt = conn.prepareStatement("UPDATE  login  SET password = '"+password +"' WHERE name = '" +  name+"'");
            rs = stmt.executeUpdate();
            if(rs ==1){
                isAllow = true;
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null, stmt, conn);
        }
        return isAllow;
    }
}

package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.etc.DBUtill.DBUtil;

public class QueryMaxLineDao {

    public int queryMaxLine(String type) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        int line = 0;
        try {
            conn = DBUtil.getConnetction();
            stmt = conn.prepareStatement("select max(line) from " + type);
            rs = stmt.executeQuery();
            if(rs.next()) {
                line = rs.getInt("max(line)")+1;
            }
            if(line==0){
                line=1;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null, stmt, conn);
        }
        
        return line;
        
    }
}

package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.etc.DBUtill.DBUtil;

public class DeleteproductDao {

    public int delete(String ids, String type){
        int id = Integer.parseInt(ids);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int isSuccess = 0;
        int line = 0;
        try {
            conn = DBUtil.getConnetction();
            QueryMaxLineDao queryMaxLineDao = new QueryMaxLineDao();
            int maxline = queryMaxLineDao.queryMaxLine(type) - 1;
            
            stmt = conn.prepareStatement("select line from "+ type + " where id = " + id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                line = rs.getInt("line");
            }
            if(line == maxline) {
                stmt = conn.prepareStatement("DELETE FROM "+ type +" WHERE id = " + id);
                isSuccess = stmt.executeUpdate();
            }else{
                stmt = conn.prepareStatement("DELETE FROM "+ type +" WHERE id = " + id);
                isSuccess = stmt.executeUpdate();
                for(int i=line+1;i<=maxline;i++){
                    stmt = conn.prepareStatement("UPDATE "+ type +" SET line=? WHERE line = " + (line+1));
                    stmt.setInt(1, line);
                    stmt.executeUpdate();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null, stmt, conn);
        }
        return isSuccess;
    }
}

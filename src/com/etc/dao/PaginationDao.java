package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.etc.DBUtill.DBUtil;
import com.etc.entity.Intermediates;
import com.etc.entity.Pagination;

public class PaginationDao {

    public Pagination paginationCount(int currentPage, String type){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        Pagination pagination = new Pagination();
        
        int row = 0;
        try {
            conn = DBUtil.getConnetction();
            stmt = conn.prepareStatement("select count(*) pro from "+ type);
            rs = stmt.executeQuery();
            if(rs.next()) {
                row = rs.getInt("pro");
            }
            pagination.setTotalCount(row);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, stmt, conn);
        }
        pagination.setCurrentPage(currentPage);
        return pagination;
    }
}

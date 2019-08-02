package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.DBUtill.DBUtil;
import com.etc.entity.Intermediates;
import com.etc.entity.Pagination;

public class ProductDao {

    public List<Intermediates> queryProduct(Pagination pagination, String type){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        List<Intermediates> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnetction();
            stmt = conn.prepareStatement("select * from "+ type +" ORDER BY id ASC LIMIT " + pagination.getOffset() + " , "+pagination .getPagesize());
            rs = stmt.executeQuery();
          
            while(rs.next()) {
                Intermediates intermediates = new Intermediates();
                String name = rs.getString("name");
                intermediates.setName(rs.getString("name"));
                intermediates.setId(rs.getInt("id"));
                intermediates.setChinaName(rs.getString("chinaname"));
                list.add(intermediates);
            }
           
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, stmt, conn);
        }
        return list;
            
    }
}

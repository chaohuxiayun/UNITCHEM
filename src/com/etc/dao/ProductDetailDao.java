package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.etc.DBUtill.DBUtil;
import com.etc.entity.Intermediates;

public class ProductDetailDao {

    public Intermediates query(String id, String type) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Intermediates intermediates = new Intermediates();
        try {
            conn = DBUtil.getConnetction();
            stmt = conn.prepareStatement("select * from "+ type +" where id = " + id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                
                intermediates.setId(rs.getInt("id"));
                intermediates.setLine(rs.getInt("line"));
                intermediates.setName(rs.getString("name"));
                intermediates.setAbbreciation(rs.getString("abbreciation"));
                intermediates.setCasno(rs.getString("casno"));
                intermediates.setMarket(rs.getString("market"));
                intermediates.setChinaName(rs.getString("chinaname"));
                intermediates.setActiveIngredient(rs.getString("activeIngredient"));
                intermediates.setType(rs.getString("type"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, stmt, conn);
        }
        return intermediates;
    }
}

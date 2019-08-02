package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.etc.DBUtill.DBUtil;
import com.etc.entity.Intermediates;

public class AddproductDao {

    public int addproduct(Intermediates intermediates){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs = 0;        
        
        try {
            conn = DBUtil.getConnetction();
            stmt = conn.prepareStatement("insert into "+intermediates.getType()+"(type,name,chinaname,casno,abbreciation,activeIngredient,market,line)values(?,?,?,?,?,?,?,?);");
            stmt.setString(1, intermediates.getType());
            stmt.setString(2, intermediates.getName());
            stmt.setString(3, intermediates.getChinaName());
            stmt.setString(4, intermediates.getCasno());
            stmt.setString(5, intermediates.getAbbreciation());
            stmt.setString(6, intermediates.getActiveIngredient());
            stmt.setString(7, intermediates.getMarket());
            stmt.setInt(8, intermediates.getLine());
            rs = stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null, stmt, conn);
        }
        return rs;
    }
}

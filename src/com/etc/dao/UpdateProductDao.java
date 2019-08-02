package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.etc.DBUtill.DBUtil;
import com.etc.entity.Intermediates;

public class UpdateProductDao {

    public int update(Intermediates intermediates){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs = 0;        
        
        try {
            conn = DBUtil.getConnetction();
            stmt = conn.prepareStatement("UPDATE "+ intermediates.getType() +" SET name=?, chinaname=?, casno=?, abbreciation=?, activeingredient=?, market=? WHERE id = " + intermediates.getId());
            stmt.setString(1, intermediates.getName());
            stmt.setString(2, intermediates.getChinaName());
            stmt.setString(3, intermediates.getCasno());
            stmt.setString(4, intermediates.getAbbreciation());
            stmt.setString(5, intermediates.getActiveIngredient());
            stmt.setString(6, intermediates.getMarket());
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

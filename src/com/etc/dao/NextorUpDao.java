package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.DBUtill.DBUtil;
import com.etc.entity.Intermediates;

public class NextorUpDao {

    public List<Intermediates> nextup(String ids,String type)
    {
        List<Intermediates> list = new ArrayList<>();
        int id = Integer.parseInt(ids);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int line = 0;
        try {
            conn = DBUtil.getConnetction();
            stmt = conn.prepareStatement("select line from "+ type +" where id = " + id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                line = rs.getInt("line");
            }
            stmt = conn.prepareStatement("select * from "+ type +" where line = " + (line-1));
            rs = stmt.executeQuery();
            if(rs.next()) {
                Intermediates intermediates = new Intermediates();
                intermediates.setId(rs.getInt("id"));
                intermediates.setLine(rs.getInt("line"));
                intermediates.setName(rs.getString("name"));
                intermediates.setAbbreciation(rs.getString("abbreciation"));
                intermediates.setCasno(rs.getString("casno"));
                intermediates.setMarket(rs.getString("market"));
                intermediates.setChinaName(rs.getString("chinaname"));
                intermediates.setActiveIngredient(rs.getString("activeIngredient"));
                list.add(intermediates);
            }else{
                Intermediates intermediates = new Intermediates();
                intermediates.setLine(0);
                list.add(intermediates);
                
            }
            
            stmt = conn.prepareStatement("select * from "+ type +" where line = " + (line+1));
            rs = stmt.executeQuery();
            if(rs.next()) {
                Intermediates intermediates = new Intermediates();
                intermediates.setId(rs.getInt("id"));
                intermediates.setLine(rs.getInt("line"));
                intermediates.setName(rs.getString("name"));
                intermediates.setAbbreciation(rs.getString("abbreciation"));
                intermediates.setCasno(rs.getString("casno"));
                intermediates.setMarket(rs.getString("market"));
                intermediates.setChinaName(rs.getString("chinaname"));
                intermediates.setActiveIngredient(rs.getString("activeIngredient"));
                list.add(intermediates);
            }else{
                Intermediates intermediates = new Intermediates();
                intermediates.setLine(0);
                list.add(intermediates);
            }
            System.out.println(list.get(0).getLine());
            System.out.println(list.get(1).getLine());
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, stmt, conn);
        }
        return list;
    }
}

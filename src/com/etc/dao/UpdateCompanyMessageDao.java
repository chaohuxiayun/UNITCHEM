package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.etc.DBUtill.DBUtil;
import com.etc.entity.Company;

public class UpdateCompanyMessageDao {

	public int update(Company c){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs = 0;        
        try {
            conn = DBUtil.getConnetction();
            stmt = conn.prepareStatement("UPDATE  companymessage  SET companyname = ?,companydetail =?, companytel=?,companymail=?,companyaddress=?  WHERE id=1");
            System.out.println(c.getCompanyaddress());
            stmt.setString(1, c.getCompanyname());
            stmt.setString(2, c.getCompanydetail());
            stmt.setString(3, c.getCompanytel());
            stmt.setString(4, c.getCompanymail());
            stmt.setString(5, c.getCompanyaddress());
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

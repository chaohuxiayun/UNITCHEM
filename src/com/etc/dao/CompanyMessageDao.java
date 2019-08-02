package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.etc.DBUtill.DBUtil;
import com.etc.entity.Company;

public class CompanyMessageDao {

    public Company company(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        Company company = new Company();
        try {
            conn = DBUtil.getConnetction();
            stmt = conn.prepareStatement("select * from companymessage");
            rs = stmt.executeQuery();
            if(rs.next()) {
                company.setCompanyaddress(rs.getString("companyaddress"));
                company.setCompanydetail(rs.getString("companydetail"));
                company.setCompanymail(rs.getString("companymail"));
                company.setCompanyname(rs.getString("companyname"));
                company.setCompanytel(rs.getString("companytel"));
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, stmt, conn);
        }
        return company;
    }
}

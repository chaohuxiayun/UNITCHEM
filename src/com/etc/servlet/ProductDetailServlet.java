package com.etc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.DBUtill.DBUtil;
import com.etc.dao.NextorUpDao;
import com.etc.dao.ProductDetailDao;
import com.etc.entity.Intermediates;

/**
 * Servlet implementation class ProductDetailServlet
 */
@WebServlet("/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         String id = request.getParameter("id");
	         String currentPage= request.getParameter("currentPage");
	         String type = request.getParameter("type");
	         ProductDetailDao productDetailDao = new ProductDetailDao();
	         NextorUpDao nextorUpDao = new NextorUpDao();
            request.setAttribute("intermediates", productDetailDao.query(id, type));
            request.setAttribute("list", nextorUpDao.nextup(id,type));
            request.setAttribute("currentPage", currentPage);
            request.getRequestDispatcher("productdetail.jsp").forward(request, response);
            
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}

}

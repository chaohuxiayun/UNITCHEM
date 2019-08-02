package com.etc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.DBUtill.DBUtil;
import com.etc.dao.PaginationDao;
import com.etc.dao.ProductDao;
import com.etc.entity.Intermediates;
import com.etc.entity.Pagination;

/**
 * Servlet implementation class Product
 */
@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String scurrentPage =  request.getParameter("currentPage");
	    String type = request.getParameter("type");
	    if(scurrentPage == null) {
	        scurrentPage = "1";
	    }
	    int currentPage = Integer.parseInt(scurrentPage);
	    ProductDao productDao = new ProductDao();
	    PaginationDao paginationDao = new PaginationDao();
	    List<Intermediates> list = new ArrayList<>();
	    Pagination pagination = paginationDao.paginationCount(currentPage, type);
	    list = productDao.queryProduct(pagination, type);
	    
            request.setAttribute("list", list);
            request.setAttribute("pagination", pagination);
            request.setAttribute("type", type);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	    
	}

}

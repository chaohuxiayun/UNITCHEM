package com.etc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.DeleteproductDao;

/**
 * Servlet implementation class DeleteproductServlet
 */
@WebServlet("/DeleteproductServlet")
public class DeleteproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteproductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		DeleteproductDao deleteproductDao = new DeleteproductDao();
		int isSuccess = deleteproductDao.delete(id, type);
		if(isSuccess == 1){
		    request.setAttribute("message", "更新成功");
		}else {
		    request.setAttribute("message", "更新失败");
		}
		request.getRequestDispatcher("product.action?type=" + type).forward(request, response);
	}

}

package com.etc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.dao.LoginDao;
import com.etc.dao.UpdatepasswordDao;

/**
 * Servlet implementation class UpdatepasswordServlet
 */
@WebServlet("/UpdatepasswordServlet")
public class UpdatepasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatepasswordServlet() {
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
	    String name = request.getParameter("name");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String password3 = request.getParameter("password3");
        LoginDao loginDao = new LoginDao();
        boolean isAllow1 = loginDao.login(name, password1);
        if( !isAllow1) {
            request.setAttribute("message", "原密码错误");
            request.getRequestDispatcher("updatepassword.jsp").forward(request, response);
        }
        if( !password2.equals(password3)){
            request.setAttribute("message", "两次密码不同");
            request.getRequestDispatcher("updatepassword.jsp").forward(request, response);
        }
        UpdatepasswordDao updatepasswordDao = new UpdatepasswordDao();
        boolean isAllow2 = updatepasswordDao.update(name, password2);
        if(isAllow2) {
            
            request.setAttribute("message", "修改成功");
        }else {
            request.setAttribute("message", "修改失败");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
	

}

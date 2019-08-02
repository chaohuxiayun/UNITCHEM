package com.etc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String name = request.getParameter("name");
	    String password = request.getParameter("password");
	    if(name==null || password==null){
	    	 request.setAttribute("message", "登录失败");
	    	 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 return;
	    }
	    if(name=="" || password==""){
	    	 request.setAttribute("message", "登录失败");
	    	 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 return;
	    }
	    LoginDao loginDao = new LoginDao();
	    System.out.println("sosss");
	    boolean isAllow = loginDao.login(name, password);
	    if(isAllow) {
	        HttpSession session = request.getSession();
	        session.setAttribute("name", name);
	        request.setAttribute("message", "登录成功");
	    }else {
	        request.setAttribute("message", "登录失败");
	    }
	    request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}

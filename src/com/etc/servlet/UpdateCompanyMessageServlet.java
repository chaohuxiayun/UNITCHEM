package com.etc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.UpdateCompanyMessageDao;
import com.etc.entity.Company;

/**
 * Servlet implementation class UpdateCompanyMessageServlet
 */
@WebServlet("/UpdateCompanyMessageServlet")
public class UpdateCompanyMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCompanyMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String add = request.getParameter("add");
		String detail = request.getParameter("detail");
		String mail = request.getParameter("mail");
		
		Company company = new Company();
		company.setCompanyaddress(add);
		company.setCompanydetail(detail);
		company.setCompanymail(mail);
		company.setCompanyname(name);
		company.setCompanytel(tel);
		UpdateCompanyMessageDao ucmd = new UpdateCompanyMessageDao();
		int i = ucmd.update(company);
		if(i == 1){
			request.setAttribute("message", "修改成功");
		}
		else {
			request.setAttribute("message", "修改失败");
		}
		request.getRequestDispatcher("companymessage.action").forward(request, response);
		
	}

}

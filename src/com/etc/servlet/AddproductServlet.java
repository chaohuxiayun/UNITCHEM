package com.etc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.AddproductDao;
import com.etc.dao.QueryMaxLineDao;
import com.etc.entity.Intermediates;

/**
 * Servlet implementation class AddproductServlet
 */
@WebServlet("/AddproductServlet")
public class AddproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddproductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("UTF-8");
	    String type = request.getParameter("type");
        String name = request.getParameter("name");
        String casno = request.getParameter("casno");
        String chinaname = request.getParameter("chinaname");
        String abbreciation = request.getParameter("abbreciation");
        String activeIngredient = request.getParameter("activeIngredient");
        String market = request.getParameter("market");
        QueryMaxLineDao queryMaxLineDao = new QueryMaxLineDao();
        int line = queryMaxLineDao.queryMaxLine(type);
        Intermediates intermediates = new Intermediates();
        intermediates.setAbbreciation(abbreciation);
        intermediates.setActiveIngredient(activeIngredient);
        intermediates.setCasno(casno);
        intermediates.setChinaName(chinaname);
        intermediates.setLine(line);
        intermediates.setMarket(market);
        intermediates.setName(name);
        intermediates.setType(type);
        AddproductDao addproductDao = new AddproductDao();
        int isSuccess = addproductDao.addproduct(intermediates);
        if(isSuccess == 1){
            request.setAttribute("message", "添加成功");
        }else {
            request.setAttribute("message", "添加失败");
        }
        request.getRequestDispatcher("product.action?type="+type).forward(request, response);
	    
	}

}

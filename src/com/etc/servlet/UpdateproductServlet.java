package com.etc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.UpdateProductDao;
import com.etc.entity.Intermediates;

/**
 * Servlet implementation class UpdateproductServlet
 */
@WebServlet("/UpdateproductServlet")
public class UpdateproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateproductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("UTF-8");
	    String type = request.getParameter("type");
	    String id = request.getParameter("id");
        String name = request.getParameter("name");
        String casno = request.getParameter("casno");
        String chinaname = request.getParameter("chinaname");
        String abbreciation = request.getParameter("abbreciation");
        String activeIngredient = request.getParameter("activeIngredient");
        String market = request.getParameter("market");
        
        Intermediates intermediates = new Intermediates();
        intermediates.setAbbreciation(abbreciation);
        intermediates.setActiveIngredient(activeIngredient);
        intermediates.setCasno(casno);
        intermediates.setChinaName(chinaname);
        intermediates.setMarket(market);
        intermediates.setName(name);
        intermediates.setType(type);
        intermediates.setId(Integer.parseInt(id));
        
        UpdateProductDao updateProductDao = new UpdateProductDao();
        int isSuccess = updateProductDao.update(intermediates);
        if(isSuccess == 1) {
            request.setAttribute("message", "更新成功");
        }else{
            request.setAttribute("message", "更新失败");
        }
        request.getRequestDispatcher("productdetail.action?id="+ id + "&type="+ type).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

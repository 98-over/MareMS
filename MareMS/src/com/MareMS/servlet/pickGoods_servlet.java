package com.MareMS.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.dbMangement;

/**
 * Servlet implementation class pickGoods_servlet
 */
@WebServlet("/pickGoods_servlet")
public class pickGoods_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pickGoods_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sellerNum="";
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		dbMangement.setUsername(userName);
		dbMangement.setPassward(password);
		try {
			sellerNum = dbMangement.getSellerNumByUsername(userName);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String[] list_hwnum=request.getParameterValues("hwnum");
		String[] list_gynum=request.getParameterValues("gynum");
		String[] list_cknum=request.getParameterValues("cknum");
		String[] list_ckacc=request.getParameterValues("ckacc");
		
		for(int i=0;i<list_cknum.length;i++) {
			if(list_ckacc[i]!=null) { 
			try {
				dbMangement.sellerGoods(list_hwnum[i], list_gynum[i], sellerNum, list_cknum[i],Integer.parseInt(list_ckacc[i]));
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		}
		response.sendRedirect("getGoods.jsp?"+list_cknum[0]);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

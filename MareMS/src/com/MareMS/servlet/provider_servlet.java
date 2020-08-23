package com.MareMS.servlet;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.dbMangement;

/**
 * Servlet implementation class provider_servlet
 */
@WebServlet("/provider_servlet")
public class provider_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public provider_servlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String supnum="";
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		dbMangement.setUsername(userName);
		dbMangement.setPassward(password);
		String[] list_cknum=request.getParameterValues("cknum");
		String[] list_hwnum=request.getParameterValues("hwnum");
		String[] list_hwname=request.getParameterValues("hwname");
		String[] list_hwtype=request.getParameterValues("hwtype");
		String[] list_rkacc=request.getParameterValues("rkacc");
		
		try {
			supnum = dbMangement.getsumNumByUsername(userName);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<list_cknum.length;i++) {
			if(list_rkacc[i]!=null) { 
			try {
				dbMangement.supplyGoods(supnum, list_cknum[i], list_hwnum[i], list_hwname[i], list_hwtype[i], Integer.parseInt(list_rkacc[i]));
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		}
		response.sendRedirect("setGoods.jsp?"+list_cknum[0]);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

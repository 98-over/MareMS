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
 * Servlet implementation class supplyGoods
 */
@WebServlet("/supplyGoods_servlet")
public class supplyGoods_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplyGoods_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String status="";
		//用户名和密码
		String userName=(String)session.getAttribute("username");
		String passWard=(String)session.getAttribute("password");
		//通过供应商编号获取用户名
		//供应商编号
		String supplyNum="";
		try {
			supplyNum = dbMangement.getsumNumByUsername(userName);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//仓库编号
		String ckNum=request.getParameter("insert_cknum");
		//货物编号
		String goodNum=dbMangement.getRandomNum(10);
		//货物名
		String goodName=request.getParameter("insert_hwname");
		//货物类型
		String goodStyle=request.getParameter("insert_hwtype");
		//货物数量
		String goodCount=request.getParameter("insert_hwaccount");
		int Count=Integer.parseInt(goodCount);
		if(supplyNum==null||ckNum==null||goodNum==null||goodName==null||goodStyle==null||Count<=0) {
			status="failure";
			session.setAttribute("status", status);
			response.sendRedirect("home.jsp");
			return;
		}	
		dbMangement.setUsername(userName);
		dbMangement.setPassward(passWard);
		try {
			dbMangement.supplyGoods(supplyNum, ckNum, goodNum, goodName, goodStyle, Count);
			response.sendRedirect("home.jsp");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

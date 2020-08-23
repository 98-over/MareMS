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
 * Servlet implementation class updateUser_servlet
 */
@WebServlet("/updateUser_servlet")
public class updateUser_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUser_servlet() {
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
		String user=(String)session.getAttribute("username");
		String identify=(String)session.getAttribute("identify");
		String name="";
		if(identify.equals("admin")) {
			name=request.getParameter("name1");
		}else {
			name=request.getParameter("name");
		}	
		String addr=request.getParameter("address");
		String phone=request.getParameter("phone");
		try {
			dbMangement.updateUser(user, name, addr, phone, identify);			
			String supplyname[]=new String[4];
					supplyname=dbMangement.changeUserName(user, identify);
			session.setAttribute("supplyName", supplyname[0]);
			session.setAttribute("address", supplyname[1]);
			session.setAttribute("phone", supplyname[2]);
			response.sendRedirect("home.jsp");
			return;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

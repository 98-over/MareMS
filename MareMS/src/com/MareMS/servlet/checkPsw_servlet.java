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
 * Servlet implementation class checkPsw_servlet
 */
@WebServlet("/checkPsw_servlet")
public class checkPsw_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkPsw_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		String status="";
		String oldpass=request.getParameter("check_o_psw");
		String newpass=request.getParameter("check_psw1");
		String again=request.getParameter("check_psw2");
		//≈–∂œ ‰»Î√‹¬Î «∑ÒŒ™ø’
		if(oldpass==null||newpass==null||again==null) {
			status="null";
			session.setAttribute("status", status);
			response.sendRedirect("home.jsp");
			return;
		}
		if(!newpass.equals(again)) {
			status="notEqual";
			session.setAttribute("status", status);
			response.sendRedirect("home.jsp");
			return;
		}
			try {
				dbMangement.changePassWard(username, oldpass, newpass);
				status="success";
				session.setAttribute("status", status);
				response.sendRedirect("home.jsp");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

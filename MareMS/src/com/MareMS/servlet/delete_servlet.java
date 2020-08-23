package com.MareMS.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MareMS.util.jdbcUtil;

/**
 * Servlet implementation class delete_servlet
 */
@WebServlet("/delete_servlet")
public class delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public delete_servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		String type = (String) request.getParameter("type");
		jdbcUtil.setUserName(username);
		jdbcUtil.setUserPwd(password);

		if (type.equals("hw")) {
			String hw_num = (String) request.getParameter("hw_num");
			String ck_num = (String) request.getParameter("ck_num");
			String sql="{call delete_Goods(?,?)}";
			try {
				Connection conn=jdbcUtil.getConnection();
				PreparedStatement pstsm=conn.prepareStatement(sql);
				pstsm.setString(1, hw_num);
				pstsm.setString(2, ck_num);
				pstsm.execute();
				conn.close();
				pstsm.close();
				response.sendRedirect("getHwStoce.jsp?"+ck_num);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

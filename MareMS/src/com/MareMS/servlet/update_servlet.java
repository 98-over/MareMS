package com.MareMS.servlet;

import java.awt.Window;
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
 * Servlet implementation class updateGoods_servlet
 */
@WebServlet("/updateGoods_servlet")
public class update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String status = "fail";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public update_servlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		request.setCharacterEncoding("utf-8"); 
		String username=(String)session.getAttribute("username");
		String password=(String)session.getAttribute("password");
		String type = (String) request.getParameter("type");
		jdbcUtil.setUserName(username);
		jdbcUtil.setUserPwd(password);
		if (type.equals("ck")) {
			String ck_num = (String) request.getParameter("ck_num");
			String ck_name = (String) request.getParameter("ck_name");
			String ck_addr = (String) request.getParameter("ck_addr");
			String ck_size = (String) request.getParameter("ck_size");
			String sql="update storehouse set ckname=?,supaddress=?,ckcap=? where cknum=?";
			try {
				Connection conn=jdbcUtil.getConnection();
				PreparedStatement pstsm=conn.prepareStatement(sql);
				pstsm.setString(1, ck_name);
				pstsm.setString(2, ck_addr);
				pstsm.setString(3, ck_size);
				pstsm.setString(4, ck_num);
				pstsm.execute();
				response.sendRedirect("getMare.jsp");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (type.equals("xs")) {
			String xs_num = (String) request.getParameter("xs_num");
			String xs_name = (String) request.getParameter("xs_name");
			String xs_addr = (String) request.getParameter("xs_addr");
			String xs_phone = (String) request.getParameter("xs_phone");
			String sql="update seller set sellername=?,supaddress=?,telphone=? where sellernum=?";
			try {
				Connection conn=jdbcUtil.getConnection();
				PreparedStatement pstsm=conn.prepareStatement(sql);
				pstsm.setString(1, xs_name);
				pstsm.setString(2, xs_addr);
				pstsm.setString(3, xs_phone);
				pstsm.setString(4, xs_num);
				pstsm.execute();
				response.sendRedirect("getSaler.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (type.equals("gy")) {
			String gy_num = (String) request.getParameter("gy_num");
			String gy_name = (String) request.getParameter("gy_name");
			String gy_addr = (String) request.getParameter("gy_addr");
			String gy_phone = (String) request.getParameter("gy_phone");
			String sql="update supplier set supname=?,supaddress=?,telphone=? where supnum=?";
			try {
				Connection conn=jdbcUtil.getConnection();
				PreparedStatement pstsm=conn.prepareStatement(sql);
				pstsm.setString(1, gy_name);
				pstsm.setString(2, gy_addr);
				pstsm.setString(3, gy_phone);
				pstsm.setString(4, gy_num);
				pstsm.execute();
				response.sendRedirect("getProvider.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (type.equals("hw")) {
			String ck_num = (String) request.getParameter("ck_num");
			String hw_num = (String) request.getParameter("hw_num");
			String hw_type = (String) request.getParameter("hw_type");
			String hw_name = (String) request.getParameter("hw_name");
			String sql="update goods set goodsname=?,goodstype=? where goodsnum2=? and cknum=?";
			try {
				Connection conn=jdbcUtil.getConnection();
				PreparedStatement pstsm=conn.prepareStatement(sql);
				pstsm.setString(1, hw_name);
				pstsm.setString(2, hw_type);
				pstsm.setString(3, hw_num);
				pstsm.setString(4, ck_num);
				pstsm.execute();
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
		doGet(request, response);
	}

}

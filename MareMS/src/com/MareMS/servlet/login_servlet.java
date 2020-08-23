package com.MareMS.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MareMS.util.jdbcUtil;
import com.db.dbMangement;

/**
 * Servlet implementation class login_servlet
 */
@WebServlet("/login_servlet")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement pstsm;
	private Connection conn = null; // 数据库连接对象

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login_servlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=utf-8");
		//PrintWriter out = response.getWriter();
		ResultSet rs = null;
		String sql = "select identify from cangku_user where username=? and password=?";
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		try {
			//创建连接
			conn = jdbcUtil.getConnection();

			//创建PerparedStatement对象(执行预编译)
			pstsm = conn.prepareStatement(sql);

			//准备参数
			pstsm.setString(1, user);
			pstsm.setString(2, pass);

			//发送参数，执行
			rs = pstsm.executeQuery();
			
			if (rs.next()) {
				System.out.println("登陆成功");
				session.setAttribute("username", user);
				session.setAttribute("password", pass);
				String name="";
				if(rs.getString(1).equals("Admin")) {
					name="admin";
				}
				else if(rs.getString(1).equals("销售商")) {
					name="saler";
				}
				else if(rs.getString(1).equals("供应商")) {
					name="provider";
				}
				//获得该用户的信息	 
				String []supplyName=new String[4];
				 supplyName=dbMangement.changeUserName(user,name);	
				session.setAttribute("identify", name);
				session.setAttribute("supplyName",supplyName[0]);
				session.setAttribute("address", supplyName[1]);
				session.setAttribute("phone", supplyName[2]);
				response.sendRedirect("home.jsp");

				rs.close();
				conn.close();

			} else {
				System.out.println("登陆失败");
				rs.close();
				pstsm.close();
				conn.close();
				session.setAttribute("message", "fail");
				response.sendRedirect("index.jsp");

			}
		} catch (Exception ex) {
			System.out.println(ex + "数据库访问失败！");
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

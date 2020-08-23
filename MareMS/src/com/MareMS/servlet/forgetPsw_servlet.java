package com.MareMS.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class forgetPsw_servlet
 */
@WebServlet("/forgetPsw_servlet")
public class forgetPsw_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgetPsw_servlet() {
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
		String forgetPsw="";
		String falsePone="falsePhone";
		String userName=request.getParameter("check_psw1");
		String telphone=request.getParameter("check_psw2");
		HttpSession session=request.getSession();
		if(userName==null||telphone==null) {
			session.setAttribute("nullInformation", "nullInformation");
			response.sendRedirect("index.jsp");
			return;
		}
		try {
			String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			//jdbc url
			String dburl= "jdbc:sqlserver://localhost:50218;DatabaseName=MareMS";
			//加载数据库驱动
			Class.forName(drivername);
			//获取数据库连接
				Connection con=DriverManager.getConnection(dburl,"sa","123456");
				PreparedStatement stmt=null;
				String sql="select username,identify from cangku_user where username=?";
				stmt=con.prepareStatement(sql);
				stmt.setString(1, userName);
				stmt.executeQuery();
				ResultSet rSet=stmt.getResultSet();
				//判断该用户身份
				String identify="";
				while(rSet.next()) {
					 identify=rSet.getString(2);
				}
			
				if(identify.equals("Admin")) {
					sql="select telphone from admin where account=?";
				}else if(identify.equals("供应商")) {
					sql="select telphone from supplier where account=?";
				}else if(identify.equals("销售商")) {
					sql="select telphone from seller where account=?";
				}
				stmt=con.prepareStatement(sql);
				stmt.setString(1, userName );
				stmt.executeQuery();
				rSet=stmt.getResultSet();
				String yourPhone="";
				while(rSet.next())
					yourPhone=rSet.getString("telphone");
				if(!telphone.equals(yourPhone)) {
					session.setAttribute("falsePone",falsePone );
					response.sendRedirect("index.jsp");
					con.close();
					return;
				}
				sql="select password from cangku_user where username=?";
				stmt=con.prepareStatement(sql);
				stmt.setString(1, userName);
				stmt.execute();
				rSet=stmt.getResultSet();
				while(rSet.next())
				forgetPsw=rSet.getString("password");
				session.setAttribute("forgetPsw",forgetPsw);
				response.getWriter().write("<script>window.location.href='index.jsp';confirm("+forgetPsw+");</script>");
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}

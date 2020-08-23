package com.MareMS.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.db.dbMangement;

/**
 * Servlet implementation class regist_servlet
 */
@WebServlet("/regist_servlet")
public class regist_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regist_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	      doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String status="";
		String userName=request.getParameter("username");
		String passWard1=request.getParameter("password1");
		String passWard2=request.getParameter("password2");
		String identify=request.getParameter("radio1");
		String name="";
		if(identify.equals("Admin")) {
			 name=request.getParameter("name");
		}else {
			name=request.getParameter("name-market");
		}
		String address=request.getParameter("addr");
		String telephone=request.getParameter("phone");
		
		String  database="MareMS";
		if(userName==null||passWard1==null||passWard2==null||name==null||address==null||telephone==null||identify==null) {
			status="information";
			session.setAttribute("status", status);
			response.sendRedirect("register.jsp");
			return;
			
		}
			dbMangement db=new dbMangement();
			try {
				//判断用户名是否已经存在
				if(db.isRegisterUser(userName)) {
					status="user";
					session.setAttribute("status", status);
					response.sendRedirect("register.jsp");
					return;
					}
				//判断密码是否一致 
					if(!passWard1.equals(passWard2)) {
						status="password";
						session.setAttribute("status", status);
						response.sendRedirect("register.jsp");
						return;
					}
				//使用存储过程创建用户，并为其授权
					if(db.call_And_grant(userName, passWard1, name, address, telephone, identify, database)) {
						status="success";
						session.setAttribute("status", status);
						response.sendRedirect("index.jsp");
						return;
					}else {
						status="failure";
						session.setAttribute("status", status);
						response.sendRedirect("register.jsp");
						return;
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}

}

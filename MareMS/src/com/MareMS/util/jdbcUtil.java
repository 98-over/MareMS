package com.MareMS.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtil {
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 加载JDBC驱动
	private static String dbURL = "jdbc:sqlserver://localhost:50218;DatabaseName=MareMS"; // 连接服务器和数据库
	private static String userName = "sa"; // 用户名
	private static String userPwd = "123456";//密码
	
	public jdbcUtil() {
		
	}
	
	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		jdbcUtil.userName = userName;
	}

	public static String getUserPwd() {
		return userPwd;
	}

	public static void setUserPwd(String userPwd) {
		jdbcUtil.userPwd = userPwd;
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, userName, userPwd);
			if (conn != null) {
				System.out.println("数据库连接成功!"); // 如果连接成功 控制台输出
			} else {
				System.out.println("数据库连接失败!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

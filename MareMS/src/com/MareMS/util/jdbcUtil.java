package com.MareMS.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtil {
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ����JDBC����
	private static String dbURL = "jdbc:sqlserver://localhost:50218;DatabaseName=MareMS"; // ���ӷ����������ݿ�
	private static String userName = "sa"; // �û���
	private static String userPwd = "123456";//����
	
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
				System.out.println("���ݿ����ӳɹ�!"); // ������ӳɹ� ����̨���
			} else {
				System.out.println("���ݿ�����ʧ��!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

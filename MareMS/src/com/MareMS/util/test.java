package com.MareMS.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstsm;
		Connection conn = null;
		jdbcUtil util=new jdbcUtil();
		ResultSet rs = null;
		String sql="select identify from users where username=? and password=?";
		String user="zsc";
		String pass="123456";
		try {
			// 2.1����������
            conn = jdbcUtil.getConnection();

            // 2.2������PerparedStatement����(ִ��Ԥ����)
            pstsm = conn.prepareStatement(sql);

            // 2.3��׼������
            pstsm.setString(1, user);
            pstsm.setString(2, pass);

            // 2.4�����Ͳ�����ִ��
            rs = pstsm.executeQuery();
			} catch (Exception ex) {
				System.out.println("�������ݿ�ʧ��!");
			}
		if(rs!=null) {
			rs.next();
			System.out.println(rs);
			System.out.println(rs.getString(1));
			conn.close();
			System.out.println("���ݿ��ѹرգ�");
		}
		else {
			System.out.println("�û������ڣ�");
		}
	}

}

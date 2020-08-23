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
			// 2.1：创建连接
            conn = jdbcUtil.getConnection();

            // 2.2：创建PerparedStatement对象(执行预编译)
            pstsm = conn.prepareStatement(sql);

            // 2.3：准备参数
            pstsm.setString(1, user);
            pstsm.setString(2, pass);

            // 2.4：发送参数，执行
            rs = pstsm.executeQuery();
			} catch (Exception ex) {
				System.out.println("访问数据库失败!");
			}
		if(rs!=null) {
			rs.next();
			System.out.println(rs);
			System.out.println(rs.getString(1));
			conn.close();
			System.out.println("数据库已关闭！");
		}
		else {
			System.out.println("用户不存在！");
		}
	}

}

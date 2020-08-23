package com.db;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import com.Model.Goods;
import com.Model.hwchuku;
import com.Model.hwruku;
import com.Model.hwstock;
import com.Model.pick_up_goods;
import com.Model.seller;
import com.Model.supplier;
import com.Model.supply_goods;
public class dbMangement {
	private  static String username;
	private static String password;
	public dbMangement() {}
	public dbMangement(String userName,String passWord) {
		username=userName;
		password=passWord;
	}
	//通过登录名和密码连接数据库
public static Connection getConnection() throws Exception{
	//jdbc驱动名
	String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//jdbc url
	String dburl= "jdbc:sqlserver://localhost:50218;DatabaseName=MareMS";
	//加载数据库驱动
	Class.forName(drivername);
	//获取数据库连接
	Connection con=DriverManager.getConnection(dburl,username,password);
	System.out.println("连接成功");
	return con;
	
	 
}
//获取销售商信息
public static ArrayList<supplier> getAllSupplier() throws Exception {
		ArrayList<supplier> suppliers=new ArrayList<supplier>();
		Connection con=dbMangement.getConnection();
		PreparedStatement stmt = null;
		String sql = "select supnum,supname,supaddress,telphone from Supplier";
		stmt=con.prepareStatement(sql);
		stmt.executeQuery();
		ResultSet rSet=stmt.getResultSet();
		while(rSet.next()) {
			supplier sup=new supplier();
			sup.setSupnum(rSet.getString("supnum"));
			sup.setSupname(rSet.getString("supname"));
			sup.setSupaddress(rSet.getString("supaddress"));
			sup.setTelephone(rSet.getString("telphone"));
			suppliers.add(sup);
		}
		con.close();
		return suppliers;	
}
//获取销售商信息
public static ArrayList<seller> getAllSellers() throws Exception{
	ArrayList<seller> sellers=new ArrayList<seller>();
	Connection con=dbMangement.getConnection();
	PreparedStatement stmt = null;
	String sql = "select sellernum,sellername,supaddress,telphone from seller";
	stmt=con.prepareStatement(sql);
	stmt.executeQuery();
	ResultSet rSet=stmt.getResultSet();
	while(rSet.next()) {
		seller sell=new seller();
		sell.setSellernum(rSet.getString("sellernum"));
		sell.setSellername(rSet.getString("sellername"));
		sell.setSupaddress(rSet.getString("supaddress"));
		sell.setTelephone(rSet.getString("telphone"));
		sellers.add(sell);
	}
	con.close();
	return sellers;
}
//根据仓库编号获取库存信息
public static ArrayList<hwstock> getAllHwStock(String ckNum) throws Exception{
	ArrayList<hwstock> hwstocks=new ArrayList<hwstock>();
	Connection conn=getConnection();
	CallableStatement call=null;
	String sql="{call goods_oncangku(?)}";
			call=conn.prepareCall(sql);
			call.setString(1, ckNum);
			call.execute();
			ResultSet rSet=call.getResultSet();
			while(rSet.next()) {
				hwstock hw=new hwstock();
				hw.setCknum(ckNum);
				hw.setGoodsnum(rSet.getString("goodsnum2"));
				hw.setGoodsstyle(rSet.getString("goodstype"));
				hw.setGoodsname(rSet.getString("goodsname"));
				hw.setSupname(rSet.getString("supname"));
				hw.setCkcount(rSet.getInt("kccount"));
				hwstocks.add(hw);
			}
			conn.close();
			return hwstocks;
}
//管理员获取入库信息
public static ArrayList<hwruku> getAllRuKuMessage() throws Exception{
	ArrayList<hwruku> hwrukus=new ArrayList<hwruku>();
	Connection conn=getConnection();
	String sql="{call SELECT_rukugoods}";
	CallableStatement call=null;
	call=conn.prepareCall(sql);
	call.execute();
	ResultSet rSet=call.getResultSet();
	while(rSet.next()) {
		hwruku rk=new hwruku();
		rk.setGoodsname(rSet.getString("goodsname"));
		rk.setSupname(rSet.getString("supname"));
		rk.setCkname(rSet.getString("ckname"));
		rk.setRukutime(rSet.getDate("rktime"));
		rk.setRukucount(rSet.getInt("rkcount"));
		hwrukus.add(rk);
	}
	conn.close();
	return hwrukus;
}
//管理员获取出库信息
public static ArrayList<hwchuku> getAllChuKuMssage() throws Exception{
	ArrayList<hwchuku> hwchukus=new ArrayList<hwchuku>();
	Connection conn=getConnection();
	String sql="{call SELECT_chukugoods}";
	CallableStatement call=null;
	call=conn.prepareCall(sql);
	call.execute();
	ResultSet rSet=call.getResultSet();
	while(rSet.next()) {
		hwchuku ck=new hwchuku();
		ck.setGoodsname(rSet.getString("goodsname"));
		ck.setSellername(rSet.getString("sellername"));
		ck.setCkname(rSet.getString("ckname"));
		ck.setChukutime(rSet.getDate("cktime"));
		ck.setChukucount(rSet.getInt("ckcount"));
		hwchukus.add(ck);
	}
	conn.close();
	return hwchukus;
	
}
//销售商查看库存
public static ArrayList<pick_up_goods> searchStore(String ckNum) throws Exception{
	ArrayList<pick_up_goods> goods=new ArrayList<pick_up_goods>();
	Connection conn=getConnection();
	CallableStatement call=null;
	String sql="{call seller_goods_storehouse(?)}";
	call=conn.prepareCall(sql);
	call.setString(1, ckNum);
	call.execute();
	ResultSet rSet=call.getResultSet();
	while(rSet.next()) {
		pick_up_goods pk=new pick_up_goods();
		pk.setHwnum(rSet.getString("goodsnum2"));
		pk.setGynum(rSet.getString("supnum"));
		pk.setCknum(rSet.getString("cknum"));
		pk.setGoodsstyle(rSet.getString("goodstype"));
		pk.setGoodsname(rSet.getString("goodsname"));
		pk.setSupname(rSet.getString("supname"));
		pk.setCkcount(rSet.getInt("kccount"));
		goods.add(pk);
	}
		conn.close();
		return goods;
	
}

//通过用户名获取他的供货信息
public static ArrayList<supply_goods> getSupplyInformation(String username,String ck_num) throws Exception{
	ArrayList<supply_goods> supplys=new ArrayList<supply_goods>();
	String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//jdbc url
	String dburl= "jdbc:sqlserver://localhost:50218;DatabaseName=MareMS";
	//加载数据库驱动
	Class.forName(drivername);
	//获取数据库连接
	Connection con1=DriverManager.getConnection(dburl,"sa","123456");
	PreparedStatement stmt=null;
	String sql="select supname,account from Supplier";
	//供应商名
	String supplyName="";
	stmt=con1.prepareStatement(sql);
	stmt.execute();
	ResultSet rSet=stmt.getResultSet();
	int flag=0;
	while(rSet.next()) {
		if(rSet.getString("account").equals(username)) {
			supplyName=rSet.getString("supname");
			flag=1;
			break;
		}
	}
	if(flag==0) {
		con1.close();
		return null;
	}
	con1.close();
	Connection conn2=getConnection();
		CallableStatement call=null;
		sql="{call SELECT_GOODS_ONSELLER(?,?)}";
		call=conn2.prepareCall(sql);
		call.setString(1, supplyName);
		call.setString(2, ck_num);
		call.execute();
		rSet=call.getResultSet();
		while(rSet.next()) {
			supply_goods supply=new supply_goods();
			supply.setGoodsNum(rSet.getString("goodsnum2"));
			supply.setCkum(rSet.getString("cknum"));
			supply.setGoodsname(rSet.getString("goodsname"));
			supply.setStyle(rSet.getString("goodstype"));
			supply.setSupplycount(rSet.getInt("kccount"));
			supplys.add(supply);
		}
	conn2.close();
	return supplys;
	
}
//供应商入库
public static void supplyGoods(String supplyNum,String ckNum,String goodNum,String goodName,String goodStyle,int goodCount) throws Exception {
	Connection con=getConnection();
	CallableStatement call=null;
	String sql="{call goods_updateruku(?,?,?,?,?,?)}";
	call=con.prepareCall(sql);
	call.setString(1, goodNum);
	call.setString(2, goodName);
	call.setString(3, goodStyle);
	call.setString(4, supplyNum);
	call.setInt(5, goodCount);
	call.setString(6, ckNum);
	call.execute();
	con.close();
}
//通过该用户的用户名获取供应商编号
public static String getsumNumByUsername(String username) throws SQLException, ClassNotFoundException {
	String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//bc url
	String dburl= "jdbc:sqlserver://localhost:50218;DatabaseName=MareMS";
	//加载数据库驱动
	Class.forName(drivername);
	//获取数据库连接
	Connection con=DriverManager.getConnection(dburl,"sa","123456");
	String supNum="";
	PreparedStatement stmt=null;
	String sql="select supnum,account from Supplier";
	stmt=con.prepareStatement(sql);
	stmt.executeQuery();
	ResultSet rsSet=stmt.getResultSet();
	while(rsSet.next()) {
		if(rsSet.getString(2).equals(username)) {
			supNum=rsSet.getString(1);
			break;
		}
	}
	return supNum;
}

//销售商提货
public static void sellerGoods(String goodsnum,String supnum,String sellernum,String cknum,int goodCount) throws Exception {
	Connection con=getConnection();
	CallableStatement call=null;
	String sql="{call goods_updatechuku(?,?,?,?,?)}";
	call=con.prepareCall(sql);
	call.setString(1, goodsnum);
	call.setString(2, supnum);
	call.setString(3, sellernum);
	call.setString(4, cknum);
	call.setInt(5, goodCount);
	call.execute();
	con.close();
}

//通过该用户的用户名获取销售商编号
public static String getSellerNumByUsername(String username) throws SQLException, ClassNotFoundException {
	String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//bc url
	String dburl= "jdbc:sqlserver://localhost:50218;DatabaseName=MareMS";
	//加载数据库驱动
	Class.forName(drivername);
	//获取数据库连接
	Connection con=DriverManager.getConnection(dburl,"sa","123456");
	String sellerNum="";
	PreparedStatement stmt=null;
	String sql="select sellernum,account from seller";
	stmt=con.prepareStatement(sql);
	stmt.executeQuery();
	ResultSet rsSet=stmt.getResultSet();
	while(rsSet.next()) {
		if(rsSet.getString(2).equals(username)) {
			sellerNum=rsSet.getString(1);
			break;
		}
	}
	return sellerNum;
}

public static boolean addSupplier(supplier sup) {
	try {
		Connection con=getConnection();
		PreparedStatement stmt=null;
		String sql="insert into Supplier values(?,?,?,?)";
		stmt=con.prepareStatement(sql);
		stmt.setString(1, sup.getSupnum());
		stmt.setString(2, sup.getSupname());
		stmt.setString(3, sup.getSupaddress());
		stmt.setString(4, sup.getTelephone());
		stmt.execute();
		username="";
		password="";
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
}
//判断当前用户是否存在
public boolean isRegisterUser(String username) throws Exception {
	String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//jdbc url
	String dburl= "jdbc:sqlserver://localhost:50218;DatabaseName=MareMS";
	//加载数据库驱动
	Class.forName(drivername);
	//获取数据库连接,注册时以超级管理员的身份
	Connection con=DriverManager.getConnection(dburl,"sa","123456");
	PreparedStatement stmt=null;
	String sql="select * from cangku_user";
	stmt=con.prepareStatement(sql);
	stmt.executeQuery();
	ResultSet rSet=stmt.getResultSet();
	while(rSet.next()) {
		String userName=rSet.getString("username");
		if(username.equals(userName)) {
			return true;
		}
	}
	return false;
}
//通过用户名来修改用户信息
public static void updateUser(String userName,String Name,String Addr,String Phone,String identify) throws ClassNotFoundException, SQLException {
	String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//jdbc url
	String dburl= "jdbc:sqlserver://localhost:50218;DatabaseName=MareMS";
	//加载数据库驱动
	Class.forName(drivername);
	//获取数据库连接,注册时以超级管理员的身份
	Connection con=DriverManager.getConnection(dburl,"sa","123456");
	String sql="";
	PreparedStatement stmt=null;
	if(identify.equals("admin")) {
		sql="update admin set adname=?,homeadd=?,telphone=? where account=?";
		stmt=con.prepareStatement(sql);
	}else if(identify.equals("saler")) {
		sql="update seller set sellername=?,supaddress=?,telphone=? where account=?";
		stmt=con.prepareStatement(sql);
	}else if(identify.equals("provider")){
		sql="update Supplier set supname=?,supaddress=?,telphone=? where account=?";
		stmt=con.prepareStatement(sql);
	}
	stmt.setString(1, Name);
	stmt.setString(2, Addr);
	stmt.setString(3, Phone);
	stmt.setString(4, userName);
	stmt.execute();
	con.close();
}
//修改密码
public static void changePassWard(String username,String oldPass,String newPass) throws  ClassNotFoundException, SQLException {
	//通过超级管理员去设置新的密码
			String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			//jdbc url
			String dburl= "jdbc:sqlserver://localhost:50218;DatabaseName=MareMS";
			//加载数据库驱动
			Class.forName(drivername);
			//获取数据库连接,注册时以超级管理员的身份
			Connection con;
			
				con = DriverManager.getConnection(dburl,"sa","123456");
				String sql="update cangku_user set password=? where username=? and password=?";
				PreparedStatement stmt=null;
				stmt=con.prepareStatement(sql);
				stmt.setString(1, newPass);
				stmt.setString(2, username);
				stmt.setString(3, oldPass);
				stmt.execute();	
				//还需要修改登录名下面的登录密码
				String sql2="{call sp_password(?,?,?)}";
				CallableStatement callstmt=null;
				callstmt=con.prepareCall(sql2);
				callstmt.setString(1,oldPass);
				callstmt.setString(2,newPass);
				callstmt.setString(3,username);
				callstmt.execute();
				con.close();
}
//得到用户名
public static String[] changeUserName(String username,String identify) throws ClassNotFoundException, SQLException {
	String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//jdbc url
	String dburl= "jdbc:sqlserver://localhost:50218;DatabaseName=MareMS";
	//加载数据库驱动
	Class.forName(drivername);
	//获取数据库连接,注册时以超级管理员的身份
	Connection con=null;
	PreparedStatement stmt=null;
	con = DriverManager.getConnection(dburl,"sa","123456");
	String sql="";
	String []result=new String[4];
	if(identify.equals("admin")) {
		 sql="select adname,homeadd,telphone,account from admin";
	}else if(identify.equals("saler")) {
		 sql="select sellername,supaddress,telphone,account from seller";
	}else if(identify.equals("provider")) {
		 sql="select supname,supaddress,telphone,account from supplier";
	}	
	stmt=con.prepareStatement(sql);
	stmt.executeQuery();
	ResultSet rSet=stmt.getResultSet();
	while(rSet.next()) {
		if(rSet.getString("account").equals(username)) {
			result[0]=rSet.getString(1);
			result[1]=rSet.getString(2);
			result[2]=rSet.getString(3);
			result[3]=rSet.getString(4);
			break;
		}
		
	} 
		con.close();
	return result;
}
//生成随机管理员，供应商，销售商编号
public static String getRandomNum(int length) {
	String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	Random random=new Random();
	StringBuffer sbBuffer=new StringBuffer();
	for(int i=0;i<length;i++) {
		int number=random.nextInt(62);
		sbBuffer.append(str.charAt(number));
	}
	return sbBuffer.toString();
}
//调用存储过程为用户授权力
public boolean call_And_grant(String userName,String passWard,String name,String address,String telephone,String identify,String database) throws Exception {
	
	String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//jdbc url
	String dburl= "jdbc:sqlserver://localhost:50218;DatabaseName=MareMS";
	//加载数据库驱动
	Class.forName(drivername);
	//获取数据库连接
	Connection con=DriverManager.getConnection(dburl,"sa","123456");
	CallableStatement call=null;
	Random random=new Random();
	String num=getRandomNum(10);
	String sql="{call INSERT_USER(?,?,?,?,?,?,?,?)}";
	call=con.prepareCall(sql);
	call.setString(1, userName);
	call.setString(2, passWard);
	call.setString(3, identify);
	call.setString(4, telephone);
	call.setString(5, num);
	call.setString(6, name);
	call.setString(7, address);
	call.setString(8, telephone);
	call.execute();
	con.close();
	return true;
}
//查询入库表的信息
//查询货物的信息,通过调用存储过程
public static ArrayList<Goods> searchAllGoods() {
	try {
		ArrayList<Goods> Goods=new ArrayList<Goods>();
		Connection con=getConnection();
		PreparedStatement stmtSearch=null;
		String sql="select * from goods";
		stmtSearch=con.prepareStatement(sql);
		stmtSearch.execute();
		ResultSet rSet=stmtSearch.getResultSet();
		while(rSet.next()) {
			Goods good=new Goods();
			good.setGoodsnum(rSet.getString("goodsnum"));
			good.setGoodsname(rSet.getString("goodsname"));
			good.setGoodsstyle(rSet.getString("goodstype"));
			good.setGoodsprice(rSet.getDouble("goodsprice"));
			Goods.add(good);
		}
		return Goods;
	}catch (Exception e) {
		// TODO: handle exception
		return null;
	}	
}
public static String getUsername() {
	return username;
}
public static void setUsername(String username) {
	dbMangement.username = username;
}
public static String getPassward() {
	return password;
}
public static void setPassward(String password) {
	dbMangement.password = password;
}
}

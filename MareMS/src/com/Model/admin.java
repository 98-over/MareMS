package com.Model;

public class admin {
	private String adminnnum;
	private String adname;
	private String homeadd;
	private String telephone;
	private Double salary;
	private String	password;
public admin(String adminNum,String adName,String homeAdd,String Telephone,Double Salary,String passWord) {
	this.adminnnum=adminNum;
	this.adname=adName;
	this.homeadd=homeAdd;
	this.telephone=Telephone;
	this.salary=Salary;
	this.password=passWord;
}
public String getAdminnnum() {
	return adminnnum;
}
public void setAdminnnum(String adminnnum) {
	this.adminnnum = adminnnum;
}
public String getAdname() {
	return adname;
}
public void setAdname(String adname) {
	this.adname = adname;
}
public String getHomeadd() {
	return homeadd;
}
public void setHomeadd(String homeadd) {
	this.homeadd = homeadd;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}

package com.Model;

public class register {
private String userName;
private String passWard;
private String name;
private String address;
private String telephone;
private String identify;
public register() {
	super();
}
public register(String userName,String passWard,String name,String address,String telephone,String identify) {
	this.userName=userName;
	this.passWard=passWard;
	this.name=name;
	this.address=address;
	this.telephone=telephone;
	this.identify=identify;
}
public String getIdentify() {
	return identify;
}
public void setIdentify(String identify) {
	this.identify = identify;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassWard() {
	return passWard;
}
public void setPassWard(String passWard) {
	this.passWard = passWard;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
}

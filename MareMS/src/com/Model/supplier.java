package com.Model;
// π©”¶…Ã
public class supplier {
private String supnum;
private String supname;
private String supaddress;
private String telephone;
public supplier() {}
public supplier(String supNum,String supName,String supAddress,String Telephone) {
	// TODO Auto-generated constructor stub
this.supnum=supNum;
this.supname=supName;
this.supaddress=supAddress;
this.telephone=Telephone;

}
public String getSupnum() {
	return supnum;
}
public void setSupnum(String supnum) {
	this.supnum = supnum;
}
public String getSupname() {
	return supname;
}
public void setSupname(String supname) {
	this.supname = supname;
}
public String getSupaddress() {
	return supaddress;
}
public void setSupaddress(String supaddress) {
	this.supaddress = supaddress;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}

}

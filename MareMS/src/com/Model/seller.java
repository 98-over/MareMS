package com.Model;

public class seller {
private String sellernum;
private String sellername;
private String supaddress;
private String telephone;
public seller() {}
public seller(String sellerNum,String sellerName,String supAddress,String Telephone) {
	this.sellernum=sellerNum;
	this.sellername=sellerName;
	this.supaddress=supAddress;
	this.telephone=Telephone;
}
public String getSellernum() {
	return sellernum;
}
public void setSellernum(String sellernum) {
	this.sellernum = sellernum;
}
public String getSellername() {
	return sellername;
}
public void setSellername(String sellername) {
	this.sellername = sellername;
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

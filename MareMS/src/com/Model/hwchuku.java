package com.Model;

import java.sql.Date;

public class hwchuku {
private String goodsname;
private String sellername;
private String ckname;
private Date chukutime;
private  int   chukucount;
public hwchuku() {}
public hwchuku(String goodsName,String sellerName,String ckName,Date chukuTime,int ckCount) {
	this.goodsname=goodsName;
	this.sellername=sellerName;
	this.ckname=ckName;
	this.chukutime=chukuTime;
	this.chukucount=ckCount;
}
public String getGoodsname() {
	return goodsname;
}
public void setGoodsname(String goodsname) {
	this.goodsname = goodsname;
}
public String getSellername() {
	return sellername;
}
public void setSellername(String sellername) {
	this.sellername = sellername;
}
public String getCkname() {
	return ckname;
}
public void setCkname(String ckname) {
	this.ckname = ckname;
}
public Date getChukutime() {
	return chukutime;
}
public void setChukutime(Date chukutime) {
	this.chukutime = chukutime;
}
public int getChukucount() {
	return chukucount;
}
public void setChukucount(int chukucount) {
	this.chukucount = chukucount;
}

}

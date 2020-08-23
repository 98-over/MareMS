package com.Model;
import java.util.Date;
public class hwruku {
	private String goodsname;
	private String supname;
	private String ckname;
	private Date rukutime;
	private  int   rukucount;
	public hwruku() {}
public hwruku(String goodsName,String supName,String ckName,Date rukuTime,int rukuCount) {
	 this.goodsname=goodsName;
	 this.supname=supName;
	 this.ckname=ckName;
	 this.rukutime=rukuTime;
	 this.rukucount=rukuCount;
}
public String getGoodsname() {
	return goodsname;
}
public void setGoodsname(String goodsname) {
	this.goodsname = goodsname;
}
public String getSupname() {
	return supname;
}
public void setSupname(String supname) {
	this.supname = supname;
}
public String getCkname() {
	return ckname;
}
public void setCkname(String ckname) {
	this.ckname = ckname;
}
public Date getRukutime() {
	return rukutime;
}
public void setRukutime(Date rukutime) {
	this.rukutime = rukutime;
}
public int getRukucount() {
	return rukucount;
}
public void setRukucount(int rukucount) {
	this.rukucount = rukucount;
}

}
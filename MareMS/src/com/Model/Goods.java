package com.Model;

public class Goods {
       private String goodsnum;
       private String goodsname;
       private String goodsstyle;
       private double goodsprice;
       public Goods() {
    	   
       }
public Goods(String Goodsnum,String Goodsname,String Goodsstyle,double Goodsprice) {
	this.goodsnum=Goodsnum;
	this.goodsstyle=Goodsstyle;
	this.goodsname=Goodsname;
	this.goodsprice=Goodsprice;
	}
public String getGoodsnum() {
	return goodsnum;
}
public void setGoodsnum(String goodsnum) {
	this.goodsnum = goodsnum;
}
public String getGoodsname() {
	return goodsname;
}
public void setGoodsname(String goodsname) {
	this.goodsname = goodsname;
}
public String getGoodsstyle() {
	return goodsstyle;
}
public void setGoodsstyle(String goodsstyle) {
	this.goodsstyle = goodsstyle;
}
public double getGoodsprice() {
	return goodsprice;
}
public void setGoodsprice(double goodsprice) {
	this.goodsprice = goodsprice;
}
}

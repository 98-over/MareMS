package com.Model;
public class hwstock {
private String goodsnum;
private String goodsstyle;
private String goodsname;
private String supname;
private  int  ckcount;
//cknum±Ì æ≤÷ø‚±‡∫≈
private String cknum;
public hwstock(){}
public hwstock(String ckNum,String goodsNum,String goodsStyle,String goodsName,String supName,int ckCount){
	this.cknum=ckNum;
	this.goodsnum=goodsNum;
	this.goodsstyle=goodsStyle;
	this.goodsname=goodsName;
	this.supname=supName;
	this.ckcount=ckCount;
}
public String getGoodsnum() {
	return goodsnum;
}
public void setGoodsnum(String goodsnum) {
	this.goodsnum = goodsnum;
}
public String getGoodsstyle() {
	return goodsstyle;
}
public void setGoodsstyle(String goodsstyle) {
	this.goodsstyle = goodsstyle;
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
public int getCkcount() {
	return ckcount;
}
public void setCkcount(int ckcount) {
	this.ckcount = ckcount;
}
public String getCknum() {
	return cknum;
}
public void setCknum(String cknum) {
	this.cknum = cknum;
}
}
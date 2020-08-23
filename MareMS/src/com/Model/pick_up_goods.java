package com.Model;

public class pick_up_goods {
	private String hwnum;
	private String gynum;
	private String cknum;
	private String goodsstyle;
	private String goodsname;
	private String supname;
	private int ckcount;
	public pick_up_goods() {}
	public pick_up_goods(String hwnum,String gynum,String ckNum,String goodsStyle,String goodsName,String supName,int ckCount ) {
		this.hwnum=hwnum;
		this.gynum=gynum;
		this.cknum=ckNum;
		this.goodsstyle=goodsStyle;
		this.goodsname=goodsName;
		this.supname=supName;
		this.ckcount=ckCount;
		
	}
	public String getHwnum() {
		return hwnum;
	}
	public void setHwnum(String hwnum) {
		this.hwnum = hwnum;
	}
	public String getGynum() {
		return gynum;
	}
	public void setGynum(String gynum) {
		this.gynum = gynum;
	}
	public String getCknum() {
		return cknum;
	}
	public void setCknum(String cknum) {
		this.cknum = cknum;
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
}

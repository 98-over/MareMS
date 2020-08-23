package com.Model;

public class supply_goods {
	private String goodsNum;
	private String ckum;
	private String style;
	private String goodsname;
	// 此商品的库存数量
	private int supplycount;

	public supply_goods() {
	}

	public supply_goods(String goodsNum, String ckNum, String Style, String goodsName, int supplyCount) {
		this.goodsNum = goodsNum;
		this.ckum = ckNum;
		this.style = Style;
		this.goodsname = goodsName;
		this.supplycount=supplyCount;
	}

	public String getCkum() {
		return ckum;
	}

	public void setCkum(String ckum) {
		this.ckum = ckum;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public int getSupplycount() {
		return supplycount;
	}

	public void setSupplycount(int supplycount) {
		this.supplycount = supplycount;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
}

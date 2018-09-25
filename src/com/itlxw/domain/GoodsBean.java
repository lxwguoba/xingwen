package com.itlxw.domain;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

@SuppressWarnings("serial")
public class GoodsBean implements Serializable {
	// 商品名称
	private String g_name;
	// 商品价格
	private Double g_price;
	// 商品库存
	private String stock;
	// 商品id
	private Long gid;
	
	public CategoryBean getCategory() {
		return category;
	}
	public void setCategory(CategoryBean category) {
		this.category = category;
	}
	// 分类id
	@JSONField(serialize=false)
	private CategoryBean category;
	// 商品图片地址
	private String imgurl;

	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public Double getG_price() {
		return g_price;
	}
	public void setG_price(Double g_price) {
		this.g_price = g_price;
	}
	@Override
	public String toString() {
		return "GoodsBean [g_name=" + g_name + ", g_price=" + g_price + ", stock=" + stock + ", gid=" + gid
				+ ", imgurl=" + imgurl + "]";
	}
	
}

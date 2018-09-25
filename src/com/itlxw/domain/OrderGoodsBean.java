package com.itlxw.domain;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

@SuppressWarnings("serial")
public class OrderGoodsBean implements Serializable {
	private Long ogid;
	// 商品名称
	private String g_name;
	// 商品价格
	private Double g_price;
	// 商品id
	private Long gid;
	
	//商品数量
	private int count;
	
	//所属订单
	@JSONField(serialize=false)
	private OrderBean orderBeanId;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Long getOgid() {
		return ogid;
	}
	public void setOgid(Long ogid) {
		this.ogid = ogid;
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
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public OrderBean getOrderBeanId() {
		return orderBeanId;
	}
	public void setOrderBeanId(OrderBean orderBeanId) {
		this.orderBeanId = orderBeanId;
	}
	
}

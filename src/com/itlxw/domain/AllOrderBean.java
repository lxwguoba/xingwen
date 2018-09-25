package com.itlxw.domain;

import java.util.List;

public class AllOrderBean {
	private String allprice;
	private String num;
	List<OrderBean> list ;
	public String getAllprice() {
		return allprice;
	}
	public void setAllprice(String allprice) {
		this.allprice = allprice;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public List<OrderBean> getList() {
		return list;
	}
	public void setList(List<OrderBean> list) {
		this.list = list;
	}
		

}

package com.itlxw.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 订单数据
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class OrderBean implements Serializable {
	//所属用户
	@JSONField(serialize=false)
	private UserBean user;
	//测试数据
	private String jsonArr;
	// 订单id
	private Long o_id;
	// 创建时间
	private String o_create_time;
	// 订单编号
	private String o_number;
	// 接待员
	private String o_receptionist;
	// 订单总价
	private String o_all_price;
	// 折扣价价
	private String o_discount_price;
	// 折扣
	private String o_discount;
	// 消费者
	private String o_customer;
	// 支付状态  1为待付款，2为已完成,3为已取消
	private int o_payStatus;
	// 商品列表
	
	private Set<OrderGoodsBean> goods = new HashSet<OrderGoodsBean>();
	public String getJsonArr() {
		return jsonArr;
	}


	public void setJsonArr(String jsonArr) {
		this.jsonArr = jsonArr;
	}
	


	public UserBean getUser() {
		return user;
	}


	public void setUser(UserBean user) {
		this.user = user;
	}


	public int getO_payStatus() {
		return o_payStatus;
	}

	public void setO_payStatus(int o_payStatus) {
		this.o_payStatus = o_payStatus;
	}

	public Set<OrderGoodsBean> getGoods() {
		return goods;
	}

	public void setGoods(Set<OrderGoodsBean> goods) {
		this.goods = goods;
	}

	public Long getO_id() {
		return o_id;
	}

	public void setO_id(Long o_id) {
		this.o_id = o_id;
	}

	public String getO_create_time() {
		return o_create_time;
	}

	public void setO_create_time(String o_create_time) {
		this.o_create_time = o_create_time;
	}

	public String getO_number() {
		return o_number;
	}

	public void setO_number(String o_number) {
		this.o_number = o_number;
	}

	public String getO_receptionist() {
		return o_receptionist;
	}

	public void setO_receptionist(String o_receptionist) {
		this.o_receptionist = o_receptionist;
	}

	public String getO_all_price() {
		return o_all_price;
	}

	public void setO_all_price(String o_all_price) {
		this.o_all_price = o_all_price;
	}

	public String getO_discount_price() {
		return o_discount_price;
	}

	public void setO_discount_price(String o_discount_price) {
		this.o_discount_price = o_discount_price;
	}

	public String getO_discount() {
		return o_discount;
	}

	public void setO_discount(String o_discount) {
		this.o_discount = o_discount;
	}

	public String getO_customer() {
		return o_customer;
	}

	public void setO_customer(String o_customer) {
		this.o_customer = o_customer;
	}

}

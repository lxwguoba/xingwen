package com.itlxw.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itlxw.domain.AllOrderBean;
import com.itlxw.domain.OrderBean;
import com.itlxw.domain.PageBean;
import com.itlxw.domain.UserBean;

public interface CreateOrderDao {
	
	public void createOrder(OrderBean ob);
	public List<OrderBean> findAllOrder();
	public OrderBean findOrderById(Long id);
	public void updata(OrderBean order);
	public List<OrderBean> findByStatus(DetachedCriteria criteria);
	public List<OrderBean> findByStatus(int status,UserBean user);
	//分页查询
	public PageBean<AllOrderBean> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

}

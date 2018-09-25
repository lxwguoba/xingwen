package com.itlxw.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import com.itlxw.dao.CreateOrderDao;
import com.itlxw.domain.AllOrderBean;
import com.itlxw.domain.OrderBean;
import com.itlxw.domain.PageBean;
import com.itlxw.domain.UserBean;

public class CreateOrderServiceImpl implements CreateOrderService {
	private CreateOrderDao createOrderDao;
	
	
	public void setCreateOrderDao(CreateOrderDao createOrderDao) {
		this.createOrderDao = createOrderDao;
	}

	public void createOrder(OrderBean ob) {
		// TODO Auto-generated method stub
		createOrderDao.createOrder(ob);
	}

	/**
	 * 查询所有的订单 没有条件的
	 */
	public List<OrderBean> findAllOrder() {
		// TODO Auto-generated method stub
		return createOrderDao.findAllOrder();
	}

	/**
	 * 通过id查询订单
	 */
	public OrderBean findOrderById(Long id) {
		// TODO Auto-generated method stub
		return createOrderDao.findOrderById(id);
	}
	
	/**
	 * 修改订单。比如支付、取消等
	 */
	public void updata(OrderBean order) {
		// TODO Auto-generated method stub
		createOrderDao.updata(order);
	}

	/**
	 * 按订单状态查询
	 */
	public List<OrderBean> findByStatus(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return createOrderDao.findByStatus(criteria);
	}

	
	/**
	 * 这个是条件查询（不推荐使用）link to  findByStatus(DetachedCriteria criteria)  这个方法比较合理 可以使用
	 */
	@Deprecated
	public List<OrderBean> findByStatus(int status,UserBean user) {
		// TODO Auto-generated method stub
		return createOrderDao.findByStatus(status,user);
	}
	
	/**
	 * 分页查询
	 */
	public PageBean<AllOrderBean> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		return createOrderDao.findByPage(pageCode,pageSize,criteria);
	}

}

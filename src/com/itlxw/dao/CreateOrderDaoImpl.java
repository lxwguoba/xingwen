package com.itlxw.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itlxw.domain.AllOrderBean;
import com.itlxw.domain.OrderBean;
import com.itlxw.domain.PageBean;
import com.itlxw.domain.UserBean;
import com.itlxw.utils.FormatMoneyUtils;

@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public class CreateOrderDaoImpl extends HibernateDaoSupport implements CreateOrderDao {

	/**
	 * 保存订单
	 */
	public void createOrder(OrderBean ob) {

		Long id = (Long) this.getHibernateTemplate().save(ob);
		// System.out.println("保存数据的id="+id);
	}

	/**
	 * 查询所有的订单
	 */
	@SuppressWarnings("unchecked")
	public List<OrderBean> findAllOrder() {
		return (List<OrderBean>) this.getHibernateTemplate().find("from OrderBean");
	}

	/**
	 * 通过id查询订单
	 */
	public OrderBean findOrderById(Long id) {
		return this.getHibernateTemplate().get(OrderBean.class, id);
	}

	 /**
	  * 修改订单信息
	  */
	public void updata(OrderBean order) {
		this.getHibernateTemplate().update(order);
	}

	/**
	 * 按条件查询
	 */
	@SuppressWarnings("unchecked")
	public List<OrderBean> findByStatus(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		List<OrderBean> list=(List<OrderBean>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
	/**
	 * 按条件查询
	 */
	@SuppressWarnings("unchecked")
	public List<OrderBean> findByStatus(int status,UserBean user) {
		// TODO Auto-generated method stub
		if(status==0){
			return (List<OrderBean>) this.getHibernateTemplate().find("from OrderBean where user=? ",user);
		}else{
			return (List<OrderBean>) this.getHibernateTemplate().find("from OrderBean where o_payStatus = ? and user=?", status,user);
		}
		
	}
	/**
	 * 分页的查询
	 */
	public PageBean<AllOrderBean> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		PageBean<AllOrderBean> page = new PageBean<AllOrderBean>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		// 先查询总记录数	select count(*)
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() > 0){
			int totalCount = list.get(0).intValue();
			// 总的记录数
			page.setTotalCount(totalCount);
		}
		
		// 强调：把select count(*) 先清空，变成  select * ...
		criteria.setProjection(null);
		// 提供分页的查询
		List<OrderBean> beanList = (List<OrderBean>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
		// 分页查询数据，每页显示的数据  使用limit
		AllOrderBean aob = new AllOrderBean();
		double money = 0;
		for (int i = 0; i < beanList.size(); i++) {
			money += (Double.parseDouble(beanList.get(i).getO_all_price())
					- Double.parseDouble(beanList.get(i).getO_discount_price()));
		}
		aob.setAllprice(FormatMoneyUtils.subMoney(money + ""));
		aob.setNum(beanList.size() + "");
		aob.setList(beanList);
		page.setBean(aob);
		return page;
	}
	
}

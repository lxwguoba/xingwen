package com.itlxw.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itlxw.domain.UserBean;
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public class UserBeanDaoImpl extends HibernateDaoSupport implements UserBeanDao {
	
	public void save(UserBean user) {
		// TODO Auto-generated method stub
         this.getHibernateTemplate().save(user);
	}

	public UserBean findByID(Long id) {
		// TODO Auto-generated method stub
		 return this.getHibernateTemplate().get(UserBean.class, id);
	}

	/**
	 * 分页的查询
	 */
	@SuppressWarnings("unchecked")
	public UserBean findByOpenid(DetachedCriteria criteria) {
		List<UserBean> list =  (List<UserBean>) this.getHibernateTemplate().findByCriteria(criteria);
		return list.size()>0?list.get(0):null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<UserBean> findAll() {
		// TODO Auto-gen erated method stub
		List<UserBean> list = (List<UserBean>) this.getHibernateTemplate().find("from UserBean");
		return list;
	}
}

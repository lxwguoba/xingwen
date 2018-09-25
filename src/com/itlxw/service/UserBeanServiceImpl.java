package com.itlxw.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itlxw.dao.UserBeanDao;
import com.itlxw.domain.UserBean;

public class UserBeanServiceImpl implements UserBeanService {
	
	private UserBeanDao userBeanDao;
	
	public void setUserBeanDao(UserBeanDao userBeanDao) {
		this.userBeanDao = userBeanDao;
	}

	public void save(UserBean user) {
		// TODO Auto-generated method stub
		userBeanDao.save(user);
	}

	public UserBean findByID(Long id) {
		// TODO Auto-generated method stub
		return userBeanDao.findByID(id);
	}

	public UserBean findByOpenid(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return userBeanDao.findByOpenid(criteria);
	}

	@Override
	public List<UserBean> findAll() {
		// TODO Auto-generated method stub
		return userBeanDao.findAll();
	}
}

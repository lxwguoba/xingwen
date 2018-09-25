package com.itlxw.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itlxw.domain.UserBean;

public interface UserBeanService {
	public void save(UserBean user);
	public UserBean findByID(Long id);
	public UserBean findByOpenid(DetachedCriteria criteria);
	public List<UserBean> findAll();
}

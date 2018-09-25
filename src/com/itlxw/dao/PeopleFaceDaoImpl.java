package com.itlxw.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itlxw.domain.ImageBean;
import com.itlxw.domain.UserBean;
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class PeopleFaceDaoImpl  extends HibernateDaoSupport implements PeopleFaceDao {
	/**
	 * 保存图片
	 */
	public void save_img(ImageBean ib) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(ib);
		
	}

	/**
	 * 保存用户信息
	 */
	public void save_user(UserBean ub) {
		// TODO Auto-generated method stub
//		this.getHibernateTemplate().save(ub);
	}

}

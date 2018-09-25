package com.itlxw.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.itlxw.domain.UserHeadImgBean;
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public class UserHeadImgDaoImpl extends HibernateDaoSupport implements UserHeadImgDao {

	/**
	 * 保存用户头像
	 */
	public void saveimg(UserHeadImgBean img) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(img);
	}
}

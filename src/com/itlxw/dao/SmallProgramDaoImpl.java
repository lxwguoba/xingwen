package com.itlxw.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itlxw.domain.ImageBean;
import com.itlxw.domain.SessionInfo;

@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public class SmallProgramDaoImpl extends HibernateDaoSupport implements SmallProgramDao {

	public void save(SessionInfo sif) {
		this.getHibernateTemplate().save(sif);
		
	}

	
	public void save_img(ImageBean fd) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(fd);
	}
}

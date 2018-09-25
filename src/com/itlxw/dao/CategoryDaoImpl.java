package com.itlxw.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itlxw.domain.CategoryBean;

@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	public void save(CategoryBean cb) {
	 this.getHibernateTemplate().save(cb);
	
	}


	@SuppressWarnings("unchecked")
	public List<CategoryBean> findAllCat() {
		// TODO Auto-generated method stub
		return (List<CategoryBean>) this.getHibernateTemplate().find("from CategoryBean");
	}

}

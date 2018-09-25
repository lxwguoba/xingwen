package com.itlxw.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.itlxw.domain.GoodsBean;
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public class AddGoodsDaoImpl extends HibernateDaoSupport implements AddGoodsDao {

	public void save(GoodsBean gb) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(gb);
	}

	@SuppressWarnings("unchecked")
	public List<GoodsBean> findAllGoods() {
		// TODO Auto-generated method stub
		return (List<GoodsBean>) this.getHibernateTemplate().find("from GoodsBean");
	}

	@Override
	public GoodsBean findById(Long id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(GoodsBean.class, id);
	}

}

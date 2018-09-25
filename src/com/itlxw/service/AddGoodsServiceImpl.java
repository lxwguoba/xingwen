package com.itlxw.service;

import java.util.List;

import com.itlxw.dao.AddGoodsDao;
import com.itlxw.domain.GoodsBean;

public class AddGoodsServiceImpl implements AddGoodsService {
   private AddGoodsDao addGoodsDao;
   
	public void setAddGoodsDao(AddGoodsDao addGoodsDao) {
	this.addGoodsDao = addGoodsDao;
}
	@Override
	public void save(GoodsBean gb) {
		addGoodsDao.save(gb);
	}

	@Override
	public List<GoodsBean> findAllGoods() {
		// TODO Auto-generated method stub
		return addGoodsDao.findAllGoods();
	}

	/**
	 * 通过id查询对应的商品
	 */
	public GoodsBean findById(Long id) {
		return  addGoodsDao.findById(id);
	}
}

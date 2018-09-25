package com.itlxw.dao;

import java.util.List;

import com.itlxw.domain.CategoryBean;
import com.itlxw.domain.GoodsBean;

public interface AddGoodsDao {
	
	public void save(GoodsBean gb);
	public List<GoodsBean> findAllGoods();
	
	public GoodsBean findById(Long id);

}

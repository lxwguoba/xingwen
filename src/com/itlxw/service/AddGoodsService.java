package com.itlxw.service;

import java.util.List;

import com.itlxw.domain.GoodsBean;

public interface AddGoodsService {

	public void save(GoodsBean gb);

	public List<GoodsBean> findAllGoods();
	
	public GoodsBean findById(Long id);
}

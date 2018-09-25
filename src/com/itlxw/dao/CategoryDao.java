package com.itlxw.dao;

import java.util.List;

import com.itlxw.domain.CategoryBean;

public interface CategoryDao {
	
	public void save(CategoryBean cb);
	public List<CategoryBean> findAllCat();

}

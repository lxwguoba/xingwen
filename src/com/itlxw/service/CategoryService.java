package com.itlxw.service;

import java.util.List;

import com.itlxw.domain.CategoryBean;

public interface CategoryService {
	public void save(CategoryBean cb);
	public List<CategoryBean> findAllCat();
}

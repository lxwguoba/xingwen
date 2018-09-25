package com.itlxw.service;

import java.util.List;

import com.itlxw.dao.CategoryDao;
import com.itlxw.domain.CategoryBean;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public void save(CategoryBean cb) {
		categoryDao.save(cb);
	}


	public List<CategoryBean> findAllCat() {
		// TODO Auto-generated method stub
		return categoryDao.findAllCat();
	}

}

package com.itlxw.service;

import com.itlxw.dao.PeopleFaceDao;
import com.itlxw.domain.ImageBean;
import com.itlxw.domain.UserBean;

public class PeopleFaceServiceImpl implements PeopleFaceService{
    public PeopleFaceDao peopleFaceDao;
	public void setPeopleFaceDao(PeopleFaceDao peopleFaceDao) {
		this.peopleFaceDao = peopleFaceDao;
	}


	public void save_img(ImageBean ib) {
		// TODO Auto-generated method stub
		peopleFaceDao.save_img(ib);
	}


	public void save_user(UserBean ub) {
		// TODO Auto-generated method stub
		peopleFaceDao.save_user(ub);
	}

}

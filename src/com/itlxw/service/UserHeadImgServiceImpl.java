package com.itlxw.service;

import com.itlxw.dao.UserHeadImgDao;
import com.itlxw.domain.UserHeadImgBean;


public class UserHeadImgServiceImpl implements UserHeadImgService {

	private UserHeadImgDao uheadDao;
	
	
	public void setUheadDao(UserHeadImgDao uheadDao) {
		this.uheadDao = uheadDao;
	}

	/**
	 * 宝存用户头像
	 */
	public void saveimg(UserHeadImgBean img) {
		// TODO Auto-generated method stub
		uheadDao.saveimg(img);
	}
}

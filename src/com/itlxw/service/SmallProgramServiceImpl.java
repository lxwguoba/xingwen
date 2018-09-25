package com.itlxw.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.itlxw.constant.ConstantConfig;
import com.itlxw.constant.IPConfig;
import com.itlxw.dao.SmallProgramDao;
import com.itlxw.domain.ImageBean;
import com.itlxw.domain.SessionInfo;
import com.itlxw.utils.FastJsonUtil;
import com.itlxw.utils.HttpUtil;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class SmallProgramServiceImpl implements SmallProgramService {

    private SmallProgramDao smallProgramDao;
    
	public void setSmallProgramDao(SmallProgramDao smallProgramDao) {
		this.smallProgramDao = smallProgramDao;
	}

	/**
	 * 登录获取sessionkey,openid
	 */
	public String login(String code) throws Exception {
		// 登录连接
		String url = IPConfig.LOGIN;
		Map<String, Object> params = new HashMap<>();
		params.put("appid", ConstantConfig.WX_APPID);
		params.put("secret", ConstantConfig.WX_SECRET);
		params.put("js_code", code);
		params.put("grant_type", "authorization_code");
		String json= HttpUtil.sendGet(url, params);
		return json;
	}
	
	
	public void save(SessionInfo sif){
		smallProgramDao.save(sif);
	}
	
	
	public void save_img(ImageBean fd) {
		// TODO Auto-generated method stub
		smallProgramDao.save_img(fd);
	}

}

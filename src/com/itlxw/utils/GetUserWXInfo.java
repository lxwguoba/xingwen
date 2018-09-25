package com.itlxw.utils;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.itlxw.constant.ConstantConfig;
import com.itlxw.constant.IPConfig;
import com.itlxw.domain.SessionInfo;
public class GetUserWXInfo {
	
	/**
	 * 登录获取sessionkey,openid
	 * 保存到sessioninfo中
	 */
	public static SessionInfo login(String code) throws Exception {
		// 登录连接
		String url = IPConfig.LOGIN;
		Map<String, Object> params = new HashMap<>();
		params.put("appid", ConstantConfig.WX_APPID);
		params.put("secret", ConstantConfig.WX_SECRET);
		params.put("js_code", code);
		params.put("grant_type", "authorization_code");
		String json= HttpUtil.sendGet(url, params);
		System.out.println(json);
		JSONObject js = new JSONObject(json);
		System.out.println(js.toString());
		String session_key = js.getString("session_key");
		Long expires_in = js.getLong("expires_in");
		String openid = js.getString("openid");
		SessionInfo sif = new SessionInfo();
		sif.setExpires_in(expires_in + "");
		sif.setOpenid(openid);
		sif.setSession_key(session_key);
		return sif;
	}
	
}

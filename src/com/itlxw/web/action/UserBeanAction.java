package com.itlxw.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;

import com.itlxw.constant.IPConfig;
import com.itlxw.domain.SessionInfo;
import com.itlxw.domain.UserBean;
import com.itlxw.domain.WXResponseData;
import com.itlxw.service.UserBeanService;
import com.itlxw.utils.FastJsonUtil;
import com.itlxw.utils.FormatTimeUtils;
import com.itlxw.utils.GetUserWXInfo;
import com.itlxw.utils.HttpUtil;
import com.itlxw.utils.SignUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@SuppressWarnings("serial")
public class UserBeanAction extends ActionSupport implements ModelDriven<UserBean> {

	private UserBeanService userBeanService;

	public void setUserBeanService(UserBeanService userBeanService) {
		this.userBeanService = userBeanService;
	}

	private UserBean userBean = new UserBean();

	@Override
	public UserBean getModel() {
		// TODO Auto-generated method stub
		return userBean;
	}

	/**
	 * 保存用户信息并登录微信
	 * 
	 * @return
	 * @throws Exception
	 */
	public String userLogin() throws Exception {
		// 先去微信哪里登录
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		try {
			String createTime = FormatTimeUtils.getNowTime();
			SessionInfo wxsession = GetUserWXInfo.login(userBean.getCode());
			// 调用service业务层
			DetachedCriteria criteria = DetachedCriteria.forClass(UserBean.class);
			// 说明，客户的级别肯定选择了一个级别
			criteria.add(Restrictions.eq("u_openid", wxsession.getOpenid()));
			UserBean isuser = userBeanService.findByOpenid(criteria);
			if (isuser != null) {
				String str = FastJsonUtil.toJSONString(isuser);
				FastJsonUtil.write_json(response, str);
			} else {
				userBean.setU_openid(wxsession.getOpenid());
				userBean.setU_session_key(wxsession.getSession_key());
				userBean.setU_expires_in(wxsession.getExpires_in());
				userBeanService.save(userBean);
				userBean.setU_register_time(createTime);
				String str = FastJsonUtil.toJSONString(userBean);
				FastJsonUtil.write_json(response, str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String str = FastJsonUtil.ajaxResult(false, e.getMessage());
			FastJsonUtil.write_json(response, str);
			
		}
		return NONE;
	}

	/**
	 * 查询所有的分类
	 * 
	 * @return
	 */
	public String findAllUser() {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<UserBean> list = userBeanService.findAll();
		String str = FastJsonUtil.toJSONString(list);
		FastJsonUtil.write_json(response, str);
		return NONE;
	}

	/**
	 * 发送客服消息 接口验证
	 */

	public String sendMessage() {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest request = ServletActionContext.getRequest();
			PrintWriter out;
			response.setContentType("text/html;charset=UTF-8");
			// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			WXResponseData wdata = new WXResponseData();
			wdata.setEchostr(echostr);
			wdata.setNonce(nonce);
			wdata.setSignature(signature);
			wdata.setTimestamp(timestamp);
			out = response.getWriter();
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			boolean lean = SignUtil.checkSignature(wdata.getSignature(), wdata.getTimestamp(), wdata.getNonce());
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			if (lean) {
				out.print(echostr);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return NONE;
	}

	/**
	 * 测试token
	 * 
	 * @return
	 */
	public String getToken() {
		Map<String, Object> map = new HashMap<>();
		try {
			String json = HttpUtil.sendGet(IPConfig.TOKEN, map);
			System.out.println(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}

	public String Message() {
		try {
			String json = HttpUtil.sendGet(IPConfig.TOKEN, null);
			JSONObject jec = new JSONObject(json);
			String token = jec.getString("access_token");
			String url = IPConfig.SEND + token;
			Map<String, Object> map = new HashMap<>();
			map.put("touser", "odmgM0SCYtq7FRM-CTdVXSy89Dxk");
			map.put("msgtype", "text");
			map.put("content", "你好刘兴文");
			String responsestr = HttpUtil.doPost(url, map);
			System.out.println(responsestr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return NONE;
	}

}

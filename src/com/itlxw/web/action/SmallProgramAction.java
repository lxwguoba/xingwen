package com.itlxw.web.action;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.itlxw.domain.Data;
import com.itlxw.domain.ImageBean;
import com.itlxw.domain.SessionInfo;
import com.itlxw.service.SmallProgramService;
import com.itlxw.utils.CreateQrCode;
import com.itlxw.utils.FastJsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class SmallProgramAction extends ActionSupport {

	/**
	 * 属性 入驻
	 */
	private String code;

	public void setCode(String code) {
		this.code = code;
	}

	public SmallProgramService smallProgramService;

	public void setSmallProgramService(SmallProgramService smallProgramService) {
		this.smallProgramService = smallProgramService;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 小程序登录获取
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() {
		HttpServletResponse response = ServletActionContext.getResponse();
		String json = null;
		JSONObject jss = new JSONObject();
		try {
			json = smallProgramService.login(code);
			JSONObject js = new JSONObject(json);
			String session_key = js.getString("session_key");
			Long expires_in = js.getLong("expires_in");
			String openid = js.getString("openid");
			SessionInfo sif = new SessionInfo();
			sif.setExpires_in(expires_in + "");
			sif.setOpenid(openid);
			sif.setSession_key(session_key);
			jss.put("code", 200);
			jss.put("msg", "登录成功");
			smallProgramService.save(sif);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jss.put("code", 400);
			jss.put("msg", "登录失败");
		}

		FastJsonUtil.write_json(response, json.toString());
		return NONE;
	}

	/**
	 * 生成二维码
	 * @return
	 */
	public String createQR() {
		try {
//			String dir = ServletActionContext.getRequest().getServletContext().getRealPath("");
//			int index = dir.lastIndexOf("/");
//			String path = dir.substring(0, index);
			String spatn="\\images\\qrcode\\";
			String content = "https://ctwxl.com?id=159";
			Long minll=System.currentTimeMillis();
			String pname=minll+".png";
			File file = new File("D:\\"+spatn+pname);
			CreateQrCode.encode(content, file,"png", BarcodeFormat.QR_CODE, 200, 200, null);
			ImageBean fd = new ImageBean();
			fd.setFilename(pname);
			fd.setFilepath(spatn+pname);
			fd.setFilemine("");
			fd.setDfilepath("D:\\"+spatn+pname);
			smallProgramService.save_img(fd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}

}

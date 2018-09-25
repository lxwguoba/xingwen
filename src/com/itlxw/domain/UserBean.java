package com.itlxw.domain;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户信息表
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class UserBean implements Serializable{
	//用户名称
	private String  u_name;
	//用户id
	private Long u_id;
	//用户地址
	private String u_address;
	//用户性别
	private String  u_gender;
	//用户手机号
	private String u_phone;
	//用户创建时间
	private String u_register_time;
	
	//code
	@JSONField(serialize=false)
	private String code;
	//用户微信的openid
	private String u_openid;
	//用户微信的session_key
	@JSONField(serialize=false)
	private String u_session_key;
	//有效时间
	@JSONField(serialize=false)
	private String u_expires_in;
	//用户头像
	private String   u_image_url;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getU_gender() {
		return u_gender;
	}
	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}
	public String getU_image_url() {
		return u_image_url;
	}
	public void setU_image_url(String u_image_url) {
		this.u_image_url = u_image_url;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public Long getU_id() {
		return u_id;
	}
	public void setU_id(Long u_id) {
		this.u_id = u_id;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_register_time() {
		return u_register_time;
	}
	public void setU_register_time(String u_register_time) {
		this.u_register_time = u_register_time;
	}
	public String getU_openid() {
		return u_openid;
	}
	public void setU_openid(String u_openid) {
		this.u_openid = u_openid;
	}
	public String getU_session_key() {
		return u_session_key;
	}
	public void setU_session_key(String u_session_key) {
		this.u_session_key = u_session_key;
	}
	public String getU_expires_in() {
		return u_expires_in;
	}
	public void setU_expires_in(String u_expires_in) {
		this.u_expires_in = u_expires_in;
	}
	
}

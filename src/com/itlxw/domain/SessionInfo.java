package com.itlxw.domain;

public class SessionInfo {

	private Long sid;
	
	// : "0WsRjqWB5dblaRS/LY/rWg==",
	private String session_key;
	private String expires_in;
	// : "odmgM0SCYtq7FRM-CTdVXSy89Dxk"
	private String openid;

	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}	
}

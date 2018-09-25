package com.itlxw.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class UserHeadImgBean {
	
	
	private Long f_id;
	//文件名称
	private String filename;
	//文件路径
	private String filepath;
	//上传的mime类型
	private String filemine;
	//所属用户
	private UserBean user;
	//删除文件的路径（阿里云服务器上的路径）
	private String dfilepath;
	public Long getF_id() {
		return f_id;
	}
	public void setF_id(Long f_id) {
		this.f_id = f_id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFilemine() {
		return filemine;
	}
	public void setFilemine(String filemine) {
		this.filemine = filemine;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public String getDfilepath() {
		return dfilepath;
	}
	public void setDfilepath(String dfilepath) {
		this.dfilepath = dfilepath;
	}
	

	
}

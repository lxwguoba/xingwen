package com.itlxw.domain;

/**
 *
 *上传图片的实体类
 * @author Administrator
 *
 */
public class ImageBean {
	private Long f_id;
	private String filename;
	private String filepath;
	private String filemine;
	//删除文件的路径
	private String dfilepath;
	
	public String getDfilepath() {
		return dfilepath;
	}
	public void setDfilepath(String dfilepath) {
		this.dfilepath = dfilepath;
	}
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
	
	
	
	
}

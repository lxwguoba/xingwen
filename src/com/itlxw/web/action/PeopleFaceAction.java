package com.itlxw.web.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.itlxw.constant.ConstantConfig;
import com.itlxw.dao.PeopleFaceDao;
import com.itlxw.domain.ImageBean;
import com.itlxw.service.PeopleFaceService;
import com.itlxw.utils.AuthService;
import com.itlxw.utils.Base64Utils;
import com.itlxw.utils.FastJsonUtil;
import com.itlxw.utils.HttpUtil;
import com.itlxw.utils.UploadUtils;
import com.opensymphony.xwork2.ActionSupport;

public class PeopleFaceAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PeopleFaceService peopleFaceService;
	 
	public void setPeopleFaceService(PeopleFaceService peopleFaceService) {
		this.peopleFaceService = peopleFaceService;
	}

	// 要上传的文件
	private File upload;
	// 文件的名称
	private String uploadFileName;
	// 文件的MIME的类型
	private String uploadContentType;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * 人脸注册
	 * 
	 * @return
	 * @throws IOException 
	 */
	public String register() throws IOException {
		HttpServletResponse response=ServletActionContext.getResponse();
	
		ImageBean fd = new ImageBean();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		String image="";
		if (uploadFileName != null) {
			String dir = ServletActionContext.getRequest().getServletContext().getRealPath("");
			int index = dir.lastIndexOf("\\");
			String path = dir.substring(0, index);
			String spatn="\\images\\aiface\\";
			// 调用接口
			String uuidname = UploadUtils.getUUIDName(uploadFileName);
			File file = new File(path+spatn+uuidname);
			FileUtils.copyFile(upload, file);
			fd.setFilename(uuidname);
			fd.setFilepath(spatn+uuidname);
			fd.setFilemine(uploadContentType);
			fd.setDfilepath(path+spatn+uuidname);
			// 创建file对象
			peopleFaceService.save_img(fd);
			image=Base64Utils.GetImageStr(path+spatn+uuidname);
			
	
		}
		
		String access_token = AuthService.getAuth();
		String url="https://aip.baidubce.com/rest/2.0/face/v2/faceset/user/add?access_token="+access_token;
//		String url="https://aip.baidubce.com/rest/2.0/face/v2/faceset/user/add";
		try {
			Map<String,Object> params=new HashMap<>();
			params.put("uid", uuid);
			params.put("group_id", ConstantConfig.GROUP_ID);
			params.put("image", image);
			params.put("user_info", uuid);
			String json= HttpUtil.doPost(url, params);
			FastJsonUtil.write_json(response, json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}

}

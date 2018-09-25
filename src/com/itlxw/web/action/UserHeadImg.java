package com.itlxw.web.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.itlxw.domain.UserBean;
import com.itlxw.domain.UserHeadImgBean;
import com.itlxw.service.UserBeanService;
import com.itlxw.service.UserHeadImgService;
import com.itlxw.utils.FastJsonUtil;
import com.itlxw.utils.UploadUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 用户头像上传model
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class UserHeadImg extends ActionSupport {

	private UserBeanService userBeanService;

	public void setUserBeanService(UserBeanService userBeanService) {
		this.userBeanService = userBeanService;
	}

	private UserHeadImgService uheadService;

	public void setUheadService(UserHeadImgService uheadService) {
		this.uheadService = uheadService;
	}

	private Long uid;

	public void setUid(Long uid) {
		this.uid =uid;
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

	public String upheadimg() {
		HttpServletResponse response = ServletActionContext.getResponse();
		 UserHeadImgBean userHeadImg = new UserHeadImgBean();
		try {
			// 通过id查找到对应的商户
			UserBean user = userBeanService.findByID(uid);
			userHeadImg.setUser(user);
			System.out.println(uploadFileName);
			if (uploadFileName != null) {
				String dir = ServletActionContext.getRequest().getServletContext().getRealPath("");
				int index = dir.lastIndexOf("/");
				String path = dir.substring(0, index);
				String spatn = "/userimgs/user/" + uid + "/";
				System.out.println(spatn);
				// 调用接口
				String uuidname = UploadUtils.getUUIDName(uploadFileName);
				File file = new File(path + spatn + uuidname);
				FileUtils.copyFile(upload, file);
				userHeadImg.setFilename(uid + uuidname);
				userHeadImg.setFilepath(spatn + uuidname);
				userHeadImg.setFilemine(uploadContentType);
				userHeadImg.setDfilepath(path + spatn + uuidname);
				uheadService.saveimg(userHeadImg);
				String str = FastJsonUtil.ajaxResult("用户头像上传成功");
				FastJsonUtil.write_json(response, str);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String str = FastJsonUtil.ajaxResultFail("用户头像上传失败");
			FastJsonUtil.write_json(response, str);
		}
		return NONE;
	}
}

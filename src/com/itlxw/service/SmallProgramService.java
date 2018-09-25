package com.itlxw.service;

import com.itlxw.domain.ImageBean;
import com.itlxw.domain.SessionInfo;

public interface SmallProgramService {
	
	public String login(String code) throws Exception;

	public void save(SessionInfo sif);

	public void save_img(ImageBean fd);

}

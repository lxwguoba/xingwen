package com.itlxw.dao;

import com.itlxw.domain.ImageBean;
import com.itlxw.domain.SessionInfo;

public interface SmallProgramDao {
	
	
	public void save(SessionInfo sif);

	public void save_img(ImageBean fd);

}

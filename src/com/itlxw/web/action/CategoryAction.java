package com.itlxw.web.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.itlxw.domain.CategoryBean;
import com.itlxw.domain.GoodsBean;
import com.itlxw.service.CategoryService;
import com.itlxw.utils.FastJsonUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("serial")
public class CategoryAction extends ActionSupport implements ModelDriven<CategoryBean> {

	private CategoryBean categoryBean = new CategoryBean();

	@Override
	public CategoryBean getModel() {
		// TODO Auto-generated method stub
		return categoryBean;
	}

	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String saveCate() {
		categoryService.save(categoryBean);
		return NONE;
	}

	/**
	 * 查询所有的分类
	 * 
	 * @return
	 */
	public String findAllCat() {
		List<CategoryBean> cat = categoryService.findAllCat();
		ValueStack valueStack2 = ActionContext.getContext().getValueStack();
		valueStack2.set("list", cat);
		return "list";
	}

	/**
	 * 查询所有的分类
	 * 
	 * @return
	 */
	public String findAllCats() {
		List<CategoryBean> list = categoryService.findAllCat();
		HttpServletResponse response = ServletActionContext.getResponse();
		String str = FastJsonUtil.toJSONString(list);
		FastJsonUtil.write_json(response, str);
		return NONE;

	}

}

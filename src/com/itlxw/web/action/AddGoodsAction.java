package com.itlxw.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.struts2.ServletActionContext;

import com.itlxw.domain.CategoryBean;
import com.itlxw.domain.GoodsBean;
import com.itlxw.service.AddGoodsService;
import com.itlxw.service.CategoryService;
import com.itlxw.utils.FastJsonUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("serial")
public class AddGoodsAction extends ActionSupport implements ModelDriven<GoodsBean> {

	private GoodsBean goodsBean = new GoodsBean();
	
	@Override
	public GoodsBean getModel() {
		// TODO Auto-generated method stub
		return goodsBean;
	}

	private AddGoodsService addGoodsService;
	
	public void setAddGoodsService(AddGoodsService addGoodsService) {
		this.addGoodsService = addGoodsService;
	}

	public String addGoods() {
		addGoodsService.save(goodsBean);
		return NONE;
	}

	/**
	 * 查询所有的分类
	 * 
	 * @return
	 */
	public String findAllGoods() {
		HttpServletResponse response=ServletActionContext.getResponse();
		List<GoodsBean> list = addGoodsService.findAllGoods();
		String str=FastJsonUtil.toJSONString(list);
		FastJsonUtil.write_json(response, str);
		return NONE;
	}
	/**
	 * 查询所有的分类
	 * 
	 * @return
	 */
	public String findById() {
		HttpServletResponse response=ServletActionContext.getResponse();
		List<GoodsBean> arr=new ArrayList<>();
		for(int i=0;i<4;i++){
			GoodsBean list = null;
			if(i==0){
				list=addGoodsService.findById(3l);
			}else if(i==1){
				list=addGoodsService.findById(5l);
			}else if(i==2){
				list=addGoodsService.findById(13l);
			}else if(i==3){
				list=addGoodsService.findById(8l);
			}
				

			System.out.println(list);
			arr.add(list);
		}
		
		String str=FastJsonUtil.toJSONString(arr);
		FastJsonUtil.write_json(response, str);
		return NONE;
	}

}

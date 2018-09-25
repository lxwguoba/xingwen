package com.itlxw.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

@SuppressWarnings("serial")
public class CategoryBean implements Serializable {
	private Long cateID;
	private String cateName;
	private Set<GoodsBean> goodslist = new HashSet<GoodsBean>();
	public Long getCateID() {
		return cateID;
	}

	public void setCateID(Long cateID) {
		this.cateID = cateID;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public Set<GoodsBean> getGoodslist() {
		return goodslist;
	}

	public void setGoodslist(Set<GoodsBean> goodslist) {
		this.goodslist = goodslist;
	}

	@Override
	public String toString() {
		return "CategoryBean [cateID=" + cateID + ", cateName=" + cateName + "]";
	}
	
	

}

package com.itlxw.web.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;

import com.itlxw.domain.AllOrderBean;
import com.itlxw.domain.GoodsBean;
import com.itlxw.domain.OrderBean;
import com.itlxw.domain.OrderGoodsBean;
import com.itlxw.domain.PageBean;
import com.itlxw.domain.UserBean;
import com.itlxw.service.AddGoodsService;
import com.itlxw.service.CreateOrderService;
import com.itlxw.service.UserBeanService;
import com.itlxw.utils.CreateOrderNumberUtils;
import com.itlxw.utils.CreateSign;
import com.itlxw.utils.FastJsonUtil;
import com.itlxw.utils.FormatMoneyUtils;
import com.itlxw.utils.FormatTimeUtils;
import com.itlxw.utils.HttpUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class CreateOrderAction extends ActionSupport implements ModelDriven<OrderBean> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderBean orderBean = new OrderBean();
	private CreateOrderService createOrderService;
	private AddGoodsService addGoodsService;

	private Integer payStatus;
	// 属性驱动的方式
	// 当前页，默认值就是1
	private Integer pageCode = 1;

	public void setPageCode(Integer pageCode) {
		if (pageCode == null) {
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}

	// 每页显示的数据的条数
	private Integer pageSize = 5;

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	private Long oid;

	public void setOid(Long oid) {
		this.oid = oid;
	}

	private Long uid;

	public void setUid(Long uid) {
		this.uid = uid;
	}

	private UserBeanService userBeanService;

	public void setUserBeanService(UserBeanService userBeanService) {
		this.userBeanService = userBeanService;
	}

	public void setAddGoodsService(AddGoodsService addGoodsService) {
		this.addGoodsService = addGoodsService;
	}

	public void setCreateOrderService(CreateOrderService createOrderService) {
		this.createOrderService = createOrderService;
	}

	/**
	 * 创建订单
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String createOrder() throws UnsupportedEncodingException {
		// 通过id查找到对应的商户
		UserBean user = userBeanService.findByID(uid);
		orderBean.setUser(user);
		String createTime = FormatTimeUtils.getNowTime();
		String orderNumber = CreateOrderNumberUtils.getOrderNoByAtomic();
		orderBean.setO_create_time(createTime);
		orderBean.setO_number(orderNumber);
		orderBean.setO_payStatus(1);
		JSONArray jsarr = new org.json.JSONArray(orderBean.getJsonArr());
		List<Long> gidlist = new ArrayList<>();
		List<Integer> countlist = new ArrayList<>();
		for (int i = 0; i < jsarr.length(); i++) {
			gidlist.add(jsarr.getJSONObject(i).getLong("gid"));
			countlist.add(jsarr.getJSONObject(i).getInt("count"));
		}
		Set<OrderGoodsBean> set = new HashSet<>();
		double money = 0.0;
		for (int j = 0; j < gidlist.size(); j++) {
			GoodsBean gb = addGoodsService.findById(gidlist.get(j));
			OrderGoodsBean ogb = new OrderGoodsBean();
			ogb.setCount(countlist.get(j));
			ogb.setG_name(gb.getG_name());
			ogb.setG_price(gb.getG_price());
			ogb.setGid(gb.getGid());
			money += (gb.getG_price() * countlist.get(j));
			// 下单减库存
			gb.setStock((Integer.parseInt(gb.getStock()) - countlist.get(j)) + "");
			set.add(ogb);
		}
		orderBean.setGoods(set);
		// 折扣
		double discount = Double.parseDouble(orderBean.getO_discount()) / 10;
		double dismoney = discount * money;
		orderBean.setO_all_price(FormatMoneyUtils.subMoney(money + ""));
		orderBean.setO_discount_price(FormatMoneyUtils.subMoney((money - dismoney) + ""));
		createOrderService.createOrder(orderBean);
		HttpServletResponse response = ServletActionContext.getResponse();
		String str = FastJsonUtil.ajaxResult(true, orderBean.getO_id() + "");
		FastJsonUtil.write_json(response, str);
		return NONE;
	}

	@Override
	public OrderBean getModel() {
		// TODO Auto-generated method stub
		return orderBean;
	}

	public String findAllOrder() {
		List<OrderBean> list = createOrderService.findAllOrder();
		HttpServletResponse response = ServletActionContext.getResponse();
		String str = FastJsonUtil.toJSONString(list);
		FastJsonUtil.write_json(response, str);
		return NONE;
	}

	public String findById() {
		OrderBean list = createOrderService.findOrderById(oid);
		HttpServletResponse response = ServletActionContext.getResponse();
		String str = FastJsonUtil.toJSONString(list);
		FastJsonUtil.write_json(response, str);
		return NONE;
	}

	/**
	 * 取消订单
	 * 
	 * @return
	 */
	public String cancelOrder() {
		HttpServletResponse response = ServletActionContext.getResponse();
		OrderBean list = createOrderService.findOrderById(oid);

		if (list.getO_payStatus() == 1) {
			list.setO_payStatus(3);
			createOrderService.updata(list);
			JSONObject json = new JSONObject();
			json.accumulate("code", "200");
			json.accumulate("msg", "取消订单成功");
			FastJsonUtil.write_json(response, json.toString());
		} else {
			JSONObject json = new JSONObject();
			json.accumulate("code", "201");
			json.accumulate("msg", "该订单不能取消");
			FastJsonUtil.write_json(response, json.toString());
		}
		return NONE;
	}

	/**
	 * 取消订单，已支付
	 * 
	 * @return
	 */
	public String pay() {
		OrderBean list = createOrderService.findOrderById(oid);
		HttpServletResponse response = ServletActionContext.getResponse();
		if (list.getO_payStatus() == 1) {
			list.setO_payStatus(2);
			createOrderService.updata(list);
			JSONObject json = new JSONObject();
			json.accumulate("code", "200");
			json.accumulate("msg", "支付成功");
			FastJsonUtil.write_json(response, json.toString());
		} else {
			JSONObject json = new JSONObject();
			json.accumulate("code", "201");
			json.accumulate("msg", "不是待付款订单");
			FastJsonUtil.write_json(response, json.toString());
		}
		return NONE;
	}

	/**
	 * 按订单状态查询订单
	 * 
	 * @return
	 */
	public String findOrderByStatus() {
		DetachedCriteria criteria = DetachedCriteria.forClass(OrderBean.class);
		UserBean user = userBeanService.findByID(uid);
		if (payStatus != null && payStatus > 0) {
			criteria.add(Restrictions.eq("o_payStatus", payStatus));
		}
		if (user != null) {
			criteria.add(Restrictions.eq("user", user));
		}
		List<OrderBean> list = createOrderService.findByStatus(criteria);
		double money = 0;
		for (int i = 0; i < list.size(); i++) {
			money += (Double.parseDouble(list.get(i).getO_all_price())
					- Double.parseDouble(list.get(i).getO_discount_price()));
		}
		AllOrderBean aob = new AllOrderBean();
		aob.setAllprice(FormatMoneyUtils.subMoney(money + ""));
		aob.setNum(list.size() + "");
		aob.setList(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		String str = FastJsonUtil.toJSONString(aob);
		FastJsonUtil.write_json(response, str);
		return NONE;
	}

	/**
	 * 分页的查询方法
	 * 
	 * @return
	 */
	public String findByPage() {
		// 调用service业务层
		DetachedCriteria criteria = DetachedCriteria.forClass(OrderBean.class);
		UserBean user = userBeanService.findByID(uid);
		if (payStatus != null && payStatus > 0) {
			criteria.add(Restrictions.eq("o_payStatus", payStatus));
		}
		if (user != null) {
			criteria.add(Restrictions.eq("user", user));
		}
		// 查询
		PageBean<AllOrderBean> page = createOrderService.findByPage(pageCode, pageSize, criteria);
		// 压栈
		HttpServletResponse response = ServletActionContext.getResponse();
		String str = FastJsonUtil.toJSONString(page);
		FastJsonUtil.write_json(response, str);
		return NONE;
	}

	public String pay_sf() {
		String time = FormatTimeUtils.getNowTime("");
		String orderNumber = CreateOrderNumberUtils.getOrderNoByAtomic();
		Map<String, String> map = new HashMap<String, String>();
		map.put("subMerchantNo", "820584455410001");
		map.put("terminalId", "58405257");
		map.put("totalAmount", "0.01");
		map.put("txnTime", time);
		map.put("appId", "wxc46fec25d6892599");
		map.put("openId", "odmgM0SCYtq7FRM-CTdVXSy89Dxk");
		map.put("version", "1.6");
		map.put("channelID", "11537418");
		map.put("charSet", "utf8");
		map.put("outOrderNo", orderNumber);
		map.put("signType", "MD5");
		
		
		
		String sign=CreateSign.getSign(map);
		System.out.println(sign);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("subMerchantNo", "820584455410001");
		map2.put("terminalId", "58405257");
		map2.put("totalAmount", "0.01");
		map2.put("txnTime", time);
		map2.put("appId", "wxc46fec25d6892599");
		map2.put("openId", "odmgM0SCYtq7FRM-CTdVXSy89Dxk");
		map2.put("version", "1.6");
		//
		map2.put("channelID", "93618734");
		map2.put("charSet", "utf8");
		map2.put("outOrderNo", orderNumber);
		map2.put("signType", "MD5");
		map2.put("sign", sign);
	
		try {
			String msg=HttpUtil.doPost("https://mposprotest.shengpay.com/mpos-runtime/command/pay/wxMiniPay", map2);
			System.out.println(msg);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return NONE;
	}
}

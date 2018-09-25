package com.itlxw.constant;

/**
 * 保存ip
 * 
 * @author Administrator
 *
 */
public class IPConfig {
	public static final String TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&"
			+ "appid=wxc46fec25d6892599&secret=cba4e3acbd9ba6e4f294826c5afbb6d3";
	public static final String LOGIN = "https://api.weixin.qq.com/sns/jscode2session";
	// 发送模版消息的链接
	public static final String SEND = "https://api.weixin.qq.com/cgi-bin/message/wxopen/"
			+ "template/send?access_token=";
	// 小程序支付接口：
	public static final String WXXCHXPAY = "https://mpospro.shengpay.com/mpos-runtime/command/pay/refund";
	//测试接口：
	public static final String WXXCHX_TEST_PAY ="https://mposprotest.shengpay.com/mpos-runtime/command/pay/wxMiniPay";

}

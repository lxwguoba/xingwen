package com.itlxw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatTimeUtils {

	public static String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		// new Date()为获取当前系统时间
		return df.format(new Date());
	}
	
	public static String getNowTime(String str) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
		// new Date()为获取当前系统时间
		return df.format(new Date());
	}
	

}

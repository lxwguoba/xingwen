package com.itlxw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateOrderNumberUtils {
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final AtomicInteger atomicInteger = new AtomicInteger(1000000);
	/**
	 * 获取同一秒钟 生成的订单号连续
	 * 
	 * @param no
	 *            数据中心编号
	 * @return 同一秒内订单连续的编号
	 */
	public static synchronized String getOrderNoByAtomic() {
	atomicInteger.getAndIncrement();
	int i = atomicInteger.get();
	String date = simpleDateFormat.format(new Date());
	return "XW"+date+"F"+ i;
}
	
}

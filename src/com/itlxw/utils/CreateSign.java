package com.itlxw.utils;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateSign {

	public static String getSign(Map<String, String> sortInfo) {
		StringBuffer s = new StringBuffer();
		String[] customerifo = { "subMerchantNo", "terminalId", "totalAmount",
				"txnTime", "appId", "openId", "version", "channelID", "charSet", "outOrderNo", "signType" };

		String[] cinfo = stringSort(customerifo);
		for (int i = 0; i < cinfo.length; i++) {
			if(i==0){
				s.append(cinfo[i]+"="+sortInfo.get(cinfo[i]));	
			}else{
				s.append("&"+cinfo[i]+"="+sortInfo.get(cinfo[i]));		
			}
			
		}
		 String md="";
		try {
			md = getMD5(s.toString()+"Abcde123456");
			System.out.println(s.toString()+"Abcde123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return md;
	}

	public static String[] stringSort(String[] s) {
		List<String> list = new ArrayList<String>(s.length);
		for (int i = 0; i < s.length; i++) {
			list.add(s[i]);
		}
		Collections.sort(list);
		return list.toArray(s);
	}
	
	public static String getMD5(String str) throws Exception {
        /** 创建MD5加密对象 */
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        /** 进行加密 */
        md5.update(str.getBytes());
        /** 获取加密后的字节数组 */
        byte[] md5Bytes = md5.digest();
        String res = "";
        for (int i = 0; i < md5Bytes.length; i++) {
            int temp = md5Bytes[i] & 0xFF;
            if (temp <= 0XF) { // 转化成十六进制不够两位，前面加零
                res += "0";
            }
            res += Integer.toHexString(temp);
        }
        return res.toUpperCase();
    }
}

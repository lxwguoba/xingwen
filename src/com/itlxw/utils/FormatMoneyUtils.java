package com.itlxw.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormatMoneyUtils {

	 /**
     * 把double保留两位小数并设置为String
     *
     * @param money
     * @return
     */
    public static String setDouble(double money) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(money);
    }

    /**
     * 也是把double保留两位小数 并
     *
     * @param money
     * @return
     */
    public static String setSSWRDouble(double money) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        // 2是显示的小数点后的显示的最多位,显示的最后位是舍入的
        nf.setMaximumFractionDigits(2);
        return nf.format(money);
    }

    /**
     * 也是把double保留两位小数 并
     *
     * @param money
     * @return
     */
    public static String setQZ(double money) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        // 2是显示的小数点后的显示的最多位,显示的最后位是舍入的
        nf.setMaximumFractionDigits(0);
        return nf.format(money);
    }

    /**
     * 把钱的后面的小数点保留2位。多余的删除
     * @param price
     * @return
     */
    public static String subMoney(String price) {
        if ("null".equals(price)){
            price="0";
        }
        String sprice = setSSWRDouble(Double.parseDouble(price));
        String behind = "00";
        String[] split = sprice.split("\\.");
        if (split.length > 1) {
            if (split[1].length() > 3) {
                behind = split[1].substring(0, 2);
            } else {
                behind = split[1];
            }
        }
        String ss = split[0] + "." + behind;
        if (ss.contains(",")) {
            return ss.replaceAll(",", "");
        } else {
            return ss;
        }
    }
}

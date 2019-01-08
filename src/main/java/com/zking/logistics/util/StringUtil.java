package com.zking.logistics.util;

public class StringUtil {
    /**
     * 判断字符串不为空且不等于""
     * @param str
     * @return
     */
    public static boolean isBlank(String str){
        return null!=str && !str.equals("");
    }
}

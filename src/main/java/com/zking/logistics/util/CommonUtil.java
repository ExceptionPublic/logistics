package com.zking.logistics.util;

import java.util.HashMap;
import java.util.Map;

public class CommonUtil {
    private static Map<String,Object> map;

    public static void createMap(){
        map=new HashMap<String,Object>();
    }

    public static void put(String key,Object value){
        map.put(key, value);
    }

    public static Map<String, Object> getMap() {
        return map;
    }
}

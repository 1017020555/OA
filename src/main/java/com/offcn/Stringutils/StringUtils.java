package com.offcn.Stringutils;

import java.util.Map;
import java.util.Set;

public class StringUtils {
    public static String parseparameterMapToString(Map<String, Object> search) {
        Set<Map.Entry<String, Object>> entries = search.entrySet();
        String str="";
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = (String)entry.getValue();
            str=str+"&"+"search_"+key+"="+value;
        }
        return str;
    }
}

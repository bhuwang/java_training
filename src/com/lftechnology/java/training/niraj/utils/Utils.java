package com.lftechnology.java.training.niraj.utils;

import java.util.Map;

public class Utils {

    public static String implode(String[] s, String delimiter) {
        StringBuilder implodedString = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            implodedString.append(s[i]);
            implodedString.append(delimiter);
        }
        String result = implodedString.toString();
        return Utils.trimEnd(result, delimiter).trim();
    }

    public static String trimEnd(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (str.endsWith(remove)) {
            return str.substring(0, str.length() - remove.length());
        }
        return str;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String[] getKeysArray(Map<String, String> map) {
        String[] keysArray = new String[map.size()];
        int i=0;
        for (String key : map.keySet()) {
            keysArray[i]=key;
            i++;
        }
        return keysArray;
    }

}

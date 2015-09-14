package com.lftechnology.java.training.niraj.ems.utils;

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
    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

}

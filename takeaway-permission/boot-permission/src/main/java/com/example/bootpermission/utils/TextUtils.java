package com.example.bootpermission.utils;

import java.util.HashMap;
import java.util.Map;

public class TextUtils {
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }
}
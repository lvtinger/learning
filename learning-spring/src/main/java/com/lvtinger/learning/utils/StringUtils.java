package com.lvtinger.learning.utils;

public final class StringUtils {
    public static boolean isEmpty(String string) {
        return null == string || string.length() == 0;
    }

    public static boolean isBlank(String string) {
        return isEmpty(string) || string.trim().length() == 0;
    }
}

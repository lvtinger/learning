package com.lvtinger.learning.utils;

import java.util.Map;

public final class MapUtils {
    public static boolean isEmpty(Map<?, ?> map) {
        return null == map || map.size() == 0;
    }
}

package com.lvtinger.learning.utils;

import java.util.Collection;

public final class CollectionUtils {
    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.size() == 0;
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}

package com.lvtinger.learning.core.provider;

import com.lvtinger.learning.utils.StringUtils;

public class Provider {
    public static <T> T load(Class<T> providerType) {
        if (null == providerType) {
            throw new RuntimeException();
        }
        return null;
    }

    public static <T> T load(Class<T> providerType, String providerName) {
        if (null == providerType) {
            throw new RuntimeException();
        }

        if (StringUtils.isBlank(providerName)) {
            throw new RuntimeException();
        }
        return null;
    }
}
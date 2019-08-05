package com.lvtinger.learning.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        if (null == loader) {
            loader = ClassUtils.class.getClassLoader();
            if (null == loader) {
                loader = ClassLoader.getSystemClassLoader();
            }
        }

        return loader;
    }

    public static List<Method> scanMethod(Class<?> type) {
        Class<?> current = type;
        List<Method> list = new ArrayList<>();
        while (!current.equals(Object.class)) {
            Method[] methods = current.getDeclaredMethods();
            if (methods.length > 0) {
                list.addAll(Arrays.asList(methods));
            }
            current = type.getSuperclass();
        }
        return list;
    }
}
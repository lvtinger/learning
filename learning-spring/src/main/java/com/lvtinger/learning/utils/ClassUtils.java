package com.lvtinger.learning.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassUtils {
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

    public static List<Method> scanClassMethod(Class<?> type) {
        if (null == type) {
            return Collections.emptyList();
        }

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

    public static List<Method> scanInterfaceMethod(Class<?> type) {
        if (null == type || !type.isInterface()) {
            return Collections.emptyList();
        }
        List<Method> result = new ArrayList<>();
        Method[] current = type.getDeclaredMethods();
        if (current.length > 0) {
            result.addAll(Arrays.asList(current));
        }
        List<Method> methods = Arrays.asList(type.getDeclaredMethods());
        Class<?>[] interfaces = type.getInterfaces();
        if (interfaces.length > 0) {
            for (Class<?> $interface : interfaces) {
                List<Method> list = scanInterfaceMethod($interface);
                if (CollectionUtils.isNotEmpty(list)) {
                    result.addAll(list);
                }
            }
        }

        return result;
    }
}

package com.lvtinger.learning.core.database.proxy;

import com.lvtinger.learning.core.database.executor.StatementExecutor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class RepositoryProxy implements InvocationHandler {

    private Class<?> type;

    private final Map<Method, StatementExecutor> cached;

    public RepositoryProxy(Class<?> type, Map<Method, StatementExecutor> cached) {
        this.type = type;
        this.cached = cached;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("toString")) {
            return type.getName();
        }

        if (proxy.getClass().equals(method.getDeclaringClass())) {
            try {
                return method.invoke(proxy, args);
            } catch (Throwable throwable) {
                throw throwable;
            }
        }

        StatementExecutor executor = cached.get(method);
        if (null == executor) {
            throw new RuntimeException();
        }

        return executor.execute(args);
    }
}

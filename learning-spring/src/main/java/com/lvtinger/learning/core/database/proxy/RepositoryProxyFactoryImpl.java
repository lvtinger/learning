package com.lvtinger.learning.core.database.proxy;

import com.lvtinger.learning.core.database.executor.StatementExecutor;
import com.lvtinger.learning.utils.ClassUtils;
import com.lvtinger.learning.utils.CollectionUtils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class RepositoryProxyFactoryImpl implements RepositoryProxyFactory {
    @Override
    public <T> T instance(Class<?> type) {
        List<Method> methods = ClassUtils.scanMethod(type);

        Map<Method, StatementExecutor> map = null;

        if (CollectionUtils.isEmpty(methods)) {
            throw new RuntimeException();
        }

        for (Method method : methods) {

        }

        return null;
    }
}
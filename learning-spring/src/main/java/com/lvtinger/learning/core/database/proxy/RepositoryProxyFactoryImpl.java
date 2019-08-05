package com.lvtinger.learning.core.database.proxy;

import com.lvtinger.learning.core.database.executor.StatementExecutor;
import com.lvtinger.learning.core.database.executor.StatementExecutorFactory;
import com.lvtinger.learning.utils.ClassUtils;
import com.lvtinger.learning.utils.CollectionUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryProxyFactoryImpl implements RepositoryProxyFactory {
    @Override
    public <T> T instance(Class<T> type) {
        List<Method> methods = ClassUtils.scanMethod(type);

        if (CollectionUtils.isEmpty(methods)) {
            throw new RuntimeException();
        }

        Map<Method, StatementExecutor> executorMapping = new HashMap<>(methods.size());

        for (Method method : methods) {
            StatementExecutor executor = StatementExecutorFactory.build(method);
            executorMapping.put(method, executor);
        }

        RepositoryProxy proxy = new RepositoryProxy(executorMapping);

        return (T) Proxy.newProxyInstance(ClassUtils.getDefaultClassLoader(),
                new Class[]{type},
                proxy);
    }
}

package com.lvtinger.learning.core.database.proxy;

public interface RepositoryProxyFactory {
    <T> T instance(Class<?> type);
}

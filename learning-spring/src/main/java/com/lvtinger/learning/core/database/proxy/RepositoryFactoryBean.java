package com.lvtinger.learning.core.database.proxy;

import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

public class RepositoryFactoryBean<T> implements FactoryBean<T> {

    private Class<T> repositoryClass;

    @Setter
    private RepositoryProxyFactory factory;

    public RepositoryFactoryBean(Class<T> repositoryClass) {
        this.repositoryClass = repositoryClass;
    }

    @Override
    public T getObject() throws Exception {
        return factory.instance(this.repositoryClass);
    }

    @Override
    public Class<?> getObjectType() {
        return this.repositoryClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

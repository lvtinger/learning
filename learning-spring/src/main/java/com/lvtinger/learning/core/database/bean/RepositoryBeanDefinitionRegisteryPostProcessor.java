package com.lvtinger.learning.core.database.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class RepositoryBeanDefinitionRegisteryPostProcessor
        implements ApplicationContextAware, BeanDefinitionRegistryPostProcessor {
    private ApplicationContext applicationContext;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
            throws BeansException {
        RepositoryClassPathDefinitionScanner scanner = new RepositoryClassPathDefinitionScanner(registry);
        scanner.setResourceLoader(this.applicationContext);
        scanner.scan("com.lvtinger.learning");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

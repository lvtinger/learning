package com.lvtinger.learning.core.database.bean;

import com.lvtinger.learning.core.annotation.Repository;
import com.lvtinger.learning.core.database.proxy.RepositoryFactoryBean;
import com.lvtinger.learning.core.database.proxy.RepositoryProxyFactory;
import com.lvtinger.learning.core.database.proxy.RepositoryProxyFactoryImpl;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

public class RepositoryClassPathDefinitionScanner extends ClassPathBeanDefinitionScanner {
    public RepositoryClassPathDefinitionScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected void registerDefaultFilters() {
        this.addIncludeFilter(new AnnotationTypeFilter(Repository.class));
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> holders = super.doScan(basePackages);
        BeanDefinitionRegistry registry = this.getRegistry();
        if (registry == null) {
            throw new RuntimeException();
        }
        RepositoryProxyFactory factory = new RepositoryProxyFactoryImpl();
        for (BeanDefinitionHolder holder : holders) {
            GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();
            definition
                    .getConstructorArgumentValues()
                    .addGenericArgumentValue(definition.getBeanClassName());
            definition.setBeanClass(RepositoryFactoryBean.class);
            definition.getPropertyValues().addPropertyValue("factory", factory);
            definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
            registry.registerBeanDefinition(holder.getBeanName(), definition);
        }
        return holders;
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        return metadata.isIndependent() && metadata.isInterface();
    }
}

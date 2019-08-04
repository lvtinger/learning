package com.lvtinger.learning.core.remote.server;

import com.lvtinger.learning.core.annotation.ExportService;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.io.IOException;
import java.util.Set;

public class ServiceClassPathDefinitionScanner extends ClassPathBeanDefinitionScanner {

    public ServiceClassPathDefinitionScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected void registerDefaultFilters() {
        // super.registerDefaultFilters();
        this.addIncludeFilter(new AnnotationTypeFilter(ExportService.class));
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> holders = super.doScan(basePackages);
        BeanDefinitionRegistry registry = this.getRegistry();
        if (null == registry) {
            throw new NullPointerException();
        }
        for (BeanDefinitionHolder holder : holders) {
            registry.registerBeanDefinition(holder.getBeanName(), holder.getBeanDefinition());
        }
        return holders;
    }

    @Override
    protected boolean isCandidateComponent(MetadataReader metadataReader) throws IOException {
        return super.isCandidateComponent(metadataReader);
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isIndependent();
    }
}

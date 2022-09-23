package com.xdl.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param importingClassMetadata : 当前类的注解信息
     * @param registry： BeanDefinition注册类，把所有需要添加到容器中的bean，调用registry.registerBeanDefinition
     *                方法手动添加进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 容器中是否包含com.xdl.bean.Blue组件
        Boolean blue = registry.containsBeanDefinition("com.xdl.bean.Blue");
        if (blue != null) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition("com.xdl.bean.Red");
            registry.registerBeanDefinition("red", beanDefinition);
        }
    }
}

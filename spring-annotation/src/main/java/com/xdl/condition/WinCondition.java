package com.xdl.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否为macos操作系统
 */
public class WinCondition implements Condition {
    /**
     *
     * @param context： 判断条件能使用的上下文环境
     * @param metadata：注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String os = environment.getProperty("os.name");
        if (os.contains("Win")) {
            return true;
        }
        return false;
    }
}

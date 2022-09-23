package com.xdl.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要倒入的组件
 */
public class MyImportSelector implements ImportSelector {
    /**
     * @param importingClassMetadata: 当前标注@Import注解类的所有注解信息
     * @return ：导入容器中的组件的全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.xdl.bean.Blue", "com.xdl.bean.Yellow"};
    }
}

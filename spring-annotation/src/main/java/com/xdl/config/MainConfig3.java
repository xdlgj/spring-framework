package com.xdl.config;

import com.xdl.bean.ColorFactoryBean;
import org.springframework.context.annotation.*;

@Configuration
public class MainConfig3 {
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}

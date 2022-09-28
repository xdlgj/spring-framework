package com.xdl.config;



import com.xdl.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // 告诉spring这是一个配置类
@ComponentScan(value = "com.xdl")
public class MainConfig4 {
    @Bean
    public Dog dog() {
        return new Dog();
    }
}

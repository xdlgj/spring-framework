package com.xdl.config;


import com.xdl.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration  // 告诉spring这是一个配置类
//读取外部配置文件中的k/v保存到运行的环境变量中
@PropertySource({"classpath:person.properties"})
public class MainConfig5 {
    @Bean
    public Person person() {
        return new Person();
    }
}

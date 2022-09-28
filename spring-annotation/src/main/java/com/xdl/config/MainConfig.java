package com.xdl.config;


import com.xdl.bean.Color;
import com.xdl.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;

/**
 * 配置类 《==》配置文件
 */
@Configuration  // 告诉spring这是一个配置类
// <context:component-scan base-package="注解所在的包名"/> 指定扫哪些包下中被@Component、@Service、@Controller、@Repository标注的类自动添加到容器中
/**
 * value: 指定要扫描的包
 * excludeFilters： 指定扫描的时候按照什么规则排除哪些组件
 * includeFilters: 指定扫描的时候只需要包含哪些组件
 * useDefaultFilters: 默认是为true包含被那四个注解标注的类，如果想要includeFilters生效该值需要设置为false
 *      FilterType.ANNOTATION: 按照注解进行过滤
 *      FilterType.CUSTOM: 自定义过滤，只要满足条件，没有被@Component、@Service、@Controller、@Repository修饰的组件也会被添加进来
 * jdk8之后，该注解可以重复使用
 */
@ComponentScan(value = "com.xdl"
        //excludeFilters = { @Filter(type = FilterType.ANNOTATION, classes = {Controller.class})},
//        includeFilters = {
//                @Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//                @Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
//        },
//        useDefaultFilters = true

)
@Import(Color.class)
public class MainConfig {
    @Bean(value = {"p1", "p2"}) // 给容器中注册一个Bean；类型为返回值的类型，id默认是用方法名作为id, 可以通过name/value手动设置id
    public Person person() {
        return new Person("李四", 20, "");
    }
}

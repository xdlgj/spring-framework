package com.xdl.ba01;

import org.springframework.stereotype.Component;

/**
 * Component:表示创建对象，对象放到容器中，作用是<bean></bean>
 *    属性：value表示对象名称，也就是bean的id属性值
 *    位置：在类的上面，表示创建此类对象
 *    和Component功能相同的创建对象的注解
 *     1、@Repository:放在dao接口的实现类上面，表示创建dao对象，持久层对象能访问数据
 *     2、@Service：放在业务层接口的实现类上面，表示创建业务层对象，业务层对象有事务的功能
 *     3、@Controller：放在控制器类上面，表示创建控制器对象，属于表示层对象。
 *                    控制器对象能接受请求，把请求的处理结果显示给用户。
 *     以上四个注解都能创建注解，但是后面三个有角色说明，表示对象是分层的，对象是属于不同层的，具有额外的功能。
 */
//@Component(value = "myStudent")
//省略value
//@Component("myStudent")
//没有提供自定义对象名称，使用框架的默认对象名称：类名首字母小写
@Component
public class Student {
    private String name;
    private int age;

    public Student() {
        System.out.println("Student 的无参构造");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

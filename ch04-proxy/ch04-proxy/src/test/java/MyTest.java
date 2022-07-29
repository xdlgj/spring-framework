import org.example.dynamicProxy.CglibInterception;
import org.example.dynamicProxy.JdkHandler;
import org.example.dynamicProxy.User;
import org.example.staticProxy.*;
import org.junit.Test;

public class MyTest {
    @Test
    public void test01() {
        You you = new You();
        MarryCompany marryCompany = new MarryCompany(you);
        marryCompany.toMarry();
    }
    @Test
    public void test02() {
        Owner owner = new Owner();
        AgentProxy agentProxy = new AgentProxy(owner);
        agentProxy.toRentHouse();
    }
    @Test
    public void test03() {
        // 获取目标对象
        Owner owner = new Owner();
        // 得到代理类
        JdkHandler jdkHandler = new JdkHandler(owner);
        //  得到代理对象
        RentHouse object = (RentHouse) jdkHandler.getProxy();
        // 通过代理调用目标对象的方法
        object.toRentHouse();

        // 获取目标对象
        You you = new You();
        // 得到代理类
        JdkHandler jdkHandler2 = new JdkHandler(you);
        //  得到代理对象
        Marry object2 = (Marry) jdkHandler2.getProxy();
        // 通过代理调用目标对象的方法
        object2.toMarry();
    }
    @Test
    public void test04() {
        // 获取目标对象
        Owner owner = new Owner();
        // 得到拦截器
        CglibInterception cglibInterception = new CglibInterception(owner);
        //  得到代理对象
        RentHouse object = (RentHouse) cglibInterception.getProxy();
        // 通过代理调用目标对象的方法
        object.toRentHouse();

        //没有实现接口的类
        User user = new User();
        CglibInterception cglibInterception1 = new CglibInterception(user);
        User user1 = ( User) cglibInterception1.getProxy();
        user1.test();
    }
}

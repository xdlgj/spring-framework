import com.xdl.spring.ClassPathXmlApplicationContext;
import com.xdl.spring.Factory;
import com.xdl.spring.dao.UserDao;
import com.xdl.spring.service.UserService;
import org.junit.Test;

public class SpringTest {
    @Test
    public void test() {
        // 得到工厂的实现对象
        Factory factory = new ClassPathXmlApplicationContext("spring.xml");
        // 得到对应的实例化对象
        UserDao userDao = (UserDao) factory.getBean("userDao");
        userDao.test();
        UserService userService = (UserService) factory.getBean("userService");
        userService.test();
    }
}

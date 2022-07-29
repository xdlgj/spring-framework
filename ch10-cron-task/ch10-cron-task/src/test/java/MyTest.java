import com.xdl.task.TaskJob;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01() {
        String config = "spring.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        TaskJob taskJob = (TaskJob) ctx.getBean("taskJob");
    }
}

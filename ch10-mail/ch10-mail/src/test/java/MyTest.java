import com.xdl.OrderManager;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyTest {
    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        OrderManager orderManager = (OrderManager) ctx.getBean("orderManager");
        orderManager.placeOrder();
    }
    @Test
    public void test02() throws MessagingException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        // 获取邮件发送器的bean对象
        JavaMailSender mailSender = (JavaMailSender) ctx.getBean("mailSender");
        // 获取邮件对象
        MimeMessage message = mailSender.createMimeMessage();
        // 设置邮件主题
        message.setSubject("Spring Mail测试");
        // 创建一个带有附件的信息帮助类
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        // 设置邮件接收者
        helper.setTo("13333759329@163.com");
        // 设置邮件的发送者
        helper.setFrom("928645139@qq.com");
        // 设置邮件内容
        helper.setText("这是一个测试附件的邮件");
        // 设置附件
        File file = new File("E:\\code\\java\\spring-framework\\ch10-mail\\ch10-mail\\src\\main\\resources\\spring.xml");
        helper.addAttachment(file.getName(), file);
        // 发送邮件
        mailSender.send(message);
    }

    @Test
    public void test03() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        System.out.println(calendar.getTime());
    }
}

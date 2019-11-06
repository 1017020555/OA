import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MailTest {

    @Test
    public void test1 () throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");
        JavaMailSenderImpl bean = context.getBean(JavaMailSenderImpl.class);

        //邮件对象
        MimeMessage mimeMessage = bean.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        helper.setFrom("abc1017020555@163.com");
        helper.setTo("1017020555@qq.com");
        helper.setSubject("这是00的邮件测试");
        helper.setText("ooooooooooooo@@##$%#^%$");
        //发送邮件
        bean.send(mimeMessage);
        System.out.println("EMAIL PASS");

    }
}

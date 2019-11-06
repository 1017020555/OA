package com.offcn.employee.utils;
import com.offcn.employee.bean.Email;
import org.quartz.*;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.util.Date;

public class EmailJob implements Job{

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDataMap map=jobExecutionContext.getMergedJobDataMap();
        Email email = (Email) map.get("email");
        JavaMailSenderImpl javaMailSender =(JavaMailSenderImpl) map.get("javaMailSender");
           Scheduler scheduler=(Scheduler) map.get("schedular");

        try {
            //邮件对象
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom("abc1017020555@163.com");
            helper.setTo(email.getEname());

            helper.setSubject(email.getTitle());
            helper.setText(email.getContent());
            //发送邮件
            javaMailSender.send(mimeMessage);
            System.out.println("EMAIL PASS");
            scheduler.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

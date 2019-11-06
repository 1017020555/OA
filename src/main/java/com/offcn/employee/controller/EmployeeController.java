package com.offcn.employee.controller;

import com.offcn.auth.service.SourcesService;
import com.offcn.employee.bean.Email;
import com.offcn.employee.bean.Employee;
import com.offcn.employee.bean.Mail;
import com.offcn.employee.service.EmployeeService;
import com.offcn.employee.utils.EmailJob;
import com.offcn.employee.utils.ValidateCode;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/code")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    private SourcesService sourcesService;

    @RequestMapping(value = "/email",method = RequestMethod.POST)
    public String email(Email email) throws SchedulerException, MessagingException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");
        JavaMailSenderImpl bean = context.getBean(JavaMailSenderImpl.class);

        //邮件对象
        MimeMessage mimeMessage = bean.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom("abc1017020555@163.com");
        helper.setTo("1017020555@qq.com");
        helper.setSubject("这是00的邮件测试11111");
        helper.setText("oooooooo11111111111");
        //发送邮件
        bean.send(mimeMessage);
        System.out.println("EMAIL PASS");

        //插入数据库

        return "message";
    }

    @RequestMapping("/li")
    @ResponseBody
    public List<Employee> li(){
        List<Employee> lists= employeeService.li();

        return lists;
    }
    @RequestMapping(value="getCode")
    public void getCode(@RequestParam(value = "time") String time, HttpServletRequest request, HttpServletResponse response) {
        ValidateCode code = new ValidateCode(100, 30, 4, 30, 25, "validateCode");
        code.getCode(request, response);
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpSession session, Employee employee,String path){
     String code=(String) session.getAttribute("validateCode");
     Employee employee1=employeeService.login(employee);

     if ((path.equals(session.getAttribute("validateCode"))) && (employee1!=null)){

         session.removeAttribute("validateCode");
         session.setAttribute("emp",employee1);

         System.out.println("111");
         return "redirect:/index.jsp";
     }
        System.out.println("222");

     return "redirect:/index.jsp";
    }

}

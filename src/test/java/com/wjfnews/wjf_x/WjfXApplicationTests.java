package com.wjfnews.wjf_x;

import com.wjfnews.wjf_x.test.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class WjfXApplicationTests {


    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Autowired
    TestService testService;

    @Test
    void mailTest1() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("这是一个标题");
        simpleMailMessage.setText("这是一封测试邮件");
        simpleMailMessage.setTo("1716416169@qq.com");
        simpleMailMessage.setFrom("1716416169@qq.com");
        javaMailSender.send(simpleMailMessage);   //一个简单的邮件

    }

    @Test
    void mailTest2() throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
        mimeMessageHelper.setSubject("这是一封复杂的邮件");
        mimeMessageHelper.setText("<p style='color:red'>这是一个测试邮件</p>", true);
        mimeMessageHelper.addAttachment("1.jpg", new File("C:\\Users\\coder\\Desktop\\1.jpg"));
        mimeMessageHelper.setTo("1716416169@qq.com");
        mimeMessageHelper.setFrom("1716416169@qq.com");
        javaMailSender.send(mimeMessage);   //一个复杂的邮件

    }

    @Test
    void Test3() {

    }

}

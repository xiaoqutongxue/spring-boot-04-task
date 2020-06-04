package com.atguigu.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot04TaskApplicationTests {


    /**
     * 邮件发送器
     */
    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        // 邮件标题
        simpleMailMessage.setSubject("通知开会");

        // 邮件内容
        simpleMailMessage.setText("今天晚上七点开会");

        // 发去哪里的地址
        simpleMailMessage.setTo("1023888198@qq.com");

        // 说明谁发的
        simpleMailMessage.setFrom("1125301721@qq.com");

        javaMailSender.send(simpleMailMessage);

    }


    /**
     * 发送复杂邮件
     *
     */

    @Test
    public void test02() throws Exception{

        // 创建一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        // 邮件标题
        helper.setSubject("通知开会");

        // 邮件内容  文字加粗
        helper.setText("<b style='color:red'>今天晚上七点开会</b>",true);

        // 发去哪里的地址
        helper.setTo("1023888198@qq.com");
        // 说明谁发的
        helper.setFrom("1125301721@qq.com");

        // 上传附件
        helper.addAttachment("1.jpg",new File("D:\\1.jpg"));
        helper.addAttachment("springboot1.5.12.txt",new File("C:\\Users\\Lenovo\\Desktop\\springboot1.5.12.txt"));
        javaMailSender.send(mimeMessage);
    }
}

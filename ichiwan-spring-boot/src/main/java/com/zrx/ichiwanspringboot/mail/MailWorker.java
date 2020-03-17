package com.zrx.ichiwanspringboot.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * Description
 * MailWorker
 * 发送邮件
 * <p>
 * Data
 * 10:06
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class MailWorker {
    private final Logger LOGGER = LoggerFactory.getLogger(MailWorker.class);

    private final JavaMailSenderImpl javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    public MailWorker(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(String receiver, String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(receiver);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        simpleMailMessage.setFrom(from);

        javaMailSender.send(simpleMailMessage);

        LOGGER.info("邮件{}已发送至{}", subject, receiver);
    }
}

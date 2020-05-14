package com.zrx.ichiwanspringboot.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
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

@Async
@Component
public class MailWorker {
    private final Logger LOGGER = LoggerFactory.getLogger(MailWorker.class);

    private final JavaMailSenderImpl javaMailSender;

    @Value("${mail.default-receiver}")
    private String defaultReceiver;

    @Value("${spring.mail.username}")
    private String from;

    public MailWorker(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
        LOGGER.info("MailWorker injected");
    }

    public void send(String receiver, String subject, String text) {
        LOGGER.info("发送邮件{}到{}", subject, receiver);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(receiver);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        simpleMailMessage.setFrom(from);

        javaMailSender.send(simpleMailMessage);

        LOGGER.info("邮件{}已发送至{}", subject, receiver);
    }


    public void send(String subject, String text) {
        send(defaultReceiver, subject, text);
    }


}

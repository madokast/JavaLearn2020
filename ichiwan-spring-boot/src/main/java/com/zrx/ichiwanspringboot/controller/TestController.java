package com.zrx.ichiwanspringboot.controller;

import com.zrx.ichiwanspringboot.mail.MailWorker;
import com.zrx.ichiwanspringboot.service.EntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * TestController
 * <p>
 * Data
 * 10:14
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RequestMapping("/test")
public class TestController {

    private final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    private final MailWorker mailWorker;

    private final EntryService entryServiceImpl;

    public TestController(MailWorker mailWorker, EntryService entryServiceImpl) {
        this.mailWorker = mailWorker;
        this.entryServiceImpl = entryServiceImpl;
    }

    @PostMapping("/send/mail")
    public void sendMail(String receiver,String subject,String text){
        LOGGER.info("/send/mail");
        LOGGER.info("receiver = {}", receiver);
        LOGGER.info("subject = {}", subject);
        LOGGER.info("text = {}", text);

        mailWorker.send(receiver,subject,text);
    }
}

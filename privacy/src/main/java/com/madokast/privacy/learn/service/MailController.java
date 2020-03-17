package com.madokast.privacy.learn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

/**
 * Description
 * MailController
 * <p>
 * Data
 * 19:13
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RequestMapping("/mail")
public class MailController {

    private final Logger LOGGER = LoggerFactory.getLogger(MailController.class);
    private final Random RANDOM = new Random();

    private final JavaMailSenderImpl javaMailSender;

    public MailController(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @GetMapping("/send/{info}")
    public Object send(@PathVariable String info) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setSubject("简单邮件");

        simpleMailMessage.setText("内容: " + info);

        simpleMailMessage.setTo("578562554@qq.com");

        simpleMailMessage.setFrom("madokaworker@163.com");

        javaMailSender.send(simpleMailMessage);

        LOGGER.info("邮件{}已发送，请注意查收",info);

        return "邮件" + info + "已发送，请注意查收";
    }

    @GetMapping("/send/mine/{info}")
    public Object sendMineMail(@PathVariable String info)throws Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setSubject("复杂邮件");

        //支持 HTML
        mimeMessageHelper.setText("内容<b>" + info + "</b>",true);

        mimeMessageHelper.setTo("578562554@qq.com");

        mimeMessageHelper.setFrom("madokaworker@163.com");

        // 图片
        byte[] picture = getPicture(200, 400, 0, 255, 0, info);
        ByteArrayDataSource byteArrayInputStream = new ByteArrayDataSource(picture, "image/jpeg");

        //上传附件
        mimeMessageHelper.addAttachment(info+".jpg",byteArrayInputStream);

        javaMailSender.send(mimeMessage);

        LOGGER.info("mine邮件{}发动成功",info);

        return "mine邮件发送成功";
    }


    public byte[] getPicture(int width,
                             int height,
                             int r,
                             int g,
                             int b,
                             String info) throws Exception {

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(new Color(r, g, b));
        graphics.fillRect(0, 0, width, height);

        graphics.setColor(Color.black);
        graphics.setFont(new Font(Font.SERIF, Font.BOLD, height / 10));
        graphics.drawString(info, RANDOM.nextInt(width / 2) + width/10, RANDOM.nextInt(height / 2) + height/10);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpeg", byteArrayOutputStream);
        final byte[] bytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return bytes;
    }
}

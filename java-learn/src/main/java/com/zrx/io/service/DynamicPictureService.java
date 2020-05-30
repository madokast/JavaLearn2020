package com.zrx.io.service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.zrx.io.Entity.DynamicPicture;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description
 * DynamicPicture
 * 动态图片服务
 * <p>
 * Data
 * 2020/5/30-17:21
 *
 * @author zrx
 * @version 1.0
 */

@Service
public class DynamicPictureService {
    private final static Logger LOGGER = LoggerFactory.getLogger(DynamicPictureService.class);


    public byte[] createDynamicPictureJpg(Map<String,Object> picture) throws IOException, InvocationTargetException, IllegalAccessException {
        DynamicPicture dynamicPicture = new DynamicPicture();
        BeanUtils.populate(dynamicPicture,picture);

        return createDynamicPictureJpg(dynamicPicture);
    }


    /**
     * 返回图片数据，jpg格式
     * 在 controller 层返回时，请指定媒体类型 produces = MediaType.IMAGE_JPEG_VALUE
     *
     * @param picture 动态图片
     * @return 图片数据
     */
    public byte[] createDynamicPictureJpg(DynamicPicture picture) throws IOException {
        int height = picture.getHeight();
        int width = picture.getWidth();
        Color backgroundColor = picture.getBackgroundColor();
        String info = picture.getInfo();

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, width, height);

        if (info != null) {
            graphics.setColor(reverse(backgroundColor));
            graphics.setFont(new Font(Font.SERIF, Font.BOLD, height / 2));
            graphics.drawString(info, ThreadLocalRandom.current().nextInt(width / 20), height / 2);
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpeg", byteArrayOutputStream);
        final byte[] bytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return bytes;
    }

    /**
     * 返回 color 的反色
     * 用于纯色图的文字颜色
     *
     * @param color 原色
     * @return 反色
     */
    private Color reverse(Color color) {
        //Bits 24-31 are alpha, 16-23 are red, 8-15 are green, 0-7 are blue
        int rgb = color.getRGB();

        // rgb 取反，但是透明度设为不透明
        return new Color((~rgb) | 0xff000000);
    }
}

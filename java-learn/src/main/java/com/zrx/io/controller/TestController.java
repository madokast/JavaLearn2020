package com.zrx.io.controller;

import com.zrx.io.Entity.DynamicPicture;
import com.zrx.io.service.DynamicPictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2020/5/30-17:01
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RequestMapping("/test")
public class TestController {
    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    private final DynamicPictureService dynamicPictureService;


    public TestController(DynamicPictureService dynamicPictureService) {
        this.dynamicPictureService = dynamicPictureService;
    }

    @GetMapping(value = "/dynamicpictureJpg/w/{width}/h/{height}/rgb/{r}/{g}/{b}/info/{info}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Object getDynamicPictureJpgByRGB(@PathVariable() Map<String, Object> map) throws IOException, InvocationTargetException, IllegalAccessException {
        return dynamicPictureService.createDynamicPictureJpg(map);
    }


    @GetMapping(value = "/dynamicpictureJpg/w/{width}/h/{height}/color/{color}/info/{info}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Object getDynamicPictureJpgByColor(@PathVariable() Map<String, Object> map) throws IOException, InvocationTargetException, IllegalAccessException {
        return dynamicPictureService.createDynamicPictureJpg(map);
    }

    @GetMapping(value = "/dynamicpictureJpg/w/{width}/h/{height}/info/{info}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Object getDynamicPictureColorRandom(@PathVariable() Map<String, Object> map) throws IOException, InvocationTargetException, IllegalAccessException {
        return dynamicPictureService.createDynamicPictureJpg(map);
    }

    @GetMapping(value = "/dynamicpictureJpg/{info}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Object getDynamicPicture(@PathVariable() Map<String, Object> map) throws IOException, InvocationTargetException, IllegalAccessException {
        return dynamicPictureService.createDynamicPictureJpg(map);
    }


    /**
     * 返回图片
     *
     * @param width  宽度
     * @param height 高度
     * @param r      rgb颜色
     * @param g      rgb颜色
     * @param b      rgb颜色
     * @param info   图片中文字
     * @return 图片jepg格式
     * @throws Exception IO异常？
     */
    @GetMapping(value = "/picture/width/{width}/height/{height}/color/{r}/{g}/{b}/info/{info}", produces = MediaType.IMAGE_JPEG_VALUE)
    @Deprecated
    public Object getPicture(@PathVariable("width") int width,
                             @PathVariable("height") int height,
                             @PathVariable("r") int r,
                             @PathVariable("g") int g,
                             @PathVariable("b") int b,
                             @PathVariable("info") String info) throws Exception {
        LOGGER.info("/picture/width/{}/height/{}/color/{}/{}/{}/info/{}", width, height, r, g, b, info);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(new Color(r, g, b));
        graphics.fillRect(0, 0, width, height);

        graphics.setColor(Color.black);
        graphics.setFont(new Font(Font.SERIF, Font.BOLD, height / 2));
        graphics.drawString(info, ThreadLocalRandom.current().nextInt(width / 20), height / 2);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpeg", byteArrayOutputStream);
        final byte[] bytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return bytes;
    }

}

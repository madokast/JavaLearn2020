package com.madokast.privacy.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Description
 * 测试返回Json格式数据
 * <p>
 * Data
 * 0:08
 *
 * @author zrx
 * @version 1.0
 */


@CrossOrigin//允许跨域
@RestController
@RequestMapping(path = "/test/json")
public class JsonController {
    private final Logger LOGGER = LoggerFactory.getLogger(JsonController.class);
    private final Random RANDOM = new Random();

    @GetMapping("/time")
    public Object getTime() {
        Map<String, Object> map = new HashMap<>();
        map.put("time", new Date());
        LOGGER.info("get mapping /test/json/time ret={}", map);
        return map;
    }

    @GetMapping("/repeat/{info}")
    public Object repeatInfo(@PathVariable("info") String info) {
        JsonInTestController jsonInTestController = new JsonInTestController(info);
        LOGGER.info("get mapping /test/json/repeat/{info} ret={}", jsonInTestController);
        return jsonInTestController;
    }

    @GetMapping("/random")
    public Object randomNumber() {
        int nextInt = RANDOM.nextInt(1000);
        JsonInTestController jsonInTestController = new JsonInTestController(nextInt);
        LOGGER.info("get mapping /test/json/random ret={}", jsonInTestController);

        return jsonInTestController;
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
    public Object getPicture(@PathVariable("width") int width,
                             @PathVariable("height") int height,
                             @PathVariable("r") int r,
                             @PathVariable("g") int g,
                             @PathVariable("b") int b,
                             @PathVariable("info") String info) throws Exception {
        LOGGER.info("get mapping /test/json/picture/width/{}/height/{}/color/{}/{}/{}/info/{}", width, height, r, g, b, info);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(new Color(r, g, b));
        graphics.fillRect(0, 0, width, height);

        graphics.setColor(Color.black);
        graphics.setFont(new Font(Font.SERIF, Font.ITALIC, height / 10));
        graphics.drawString(info, RANDOM.nextInt(width / 2), RANDOM.nextInt(height / 2));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpeg", byteArrayOutputStream);
        final byte[] bytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return bytes;

    }

    @PostMapping("/post/person")
    public Object receivePerson(@RequestBody PersonInTestController person){
        LOGGER.info("post mapping /test/json/post/person = {}",person);

        return new JsonInTestController(person);
    }


    private static class JsonInTestController {
        Object data;
        Date date;

        public JsonInTestController(Object data) {
            this.data = data;
            date = new Date();
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "JsonInTestController{" +
                    "data=" + data +
                    ", date=" + date +
                    '}';
        }
    }

    private static class PersonInTestController{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "PersonInTestController{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}


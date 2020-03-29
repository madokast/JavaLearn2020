package com.zrx.jvm;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Description
 * 常量池
 * <p>
 * Data
 * 2020/3/26-18:35
 *
 * @author zrx
 * @version 1.0
 */

@Component
@Invoking(createdTime = "2020-03-26 18:36", info = "常量池")
public class 常量池 {
    private final static Logger LOGGER = LoggerFactory.getLogger(常量池.class);

    @Invoking(createdTime = "2020-03-26 18:36", info = "字符串intern")
    public void 字符串intern() {
        LOGGER.info("\"a\" == new String(\"a\") -->{}", "a" == new String("a"));

        LOGGER.info("\"a\" == new String(\"a\").intern() -->{}", "a" == new String("a").intern());
    }

    @Invoking(createdTime = "2020-03-26 18:41", info = "字符串引用改变")
    public void 字符串引用改变() {
        String a = new String("a");

        String a_ref = a;

        String s_intern = a.intern();

        LOGGER.info("a==a_ref -->{}", a == a_ref);


        LOGGER.info("a==\"a\" -->{}", a == "a");


        LOGGER.info("a_ref==\"a\" -->{}", a_ref == "a");

        LOGGER.info("s_intern==\"a\" = {}", s_intern == "a");

        LOGGER.info("a==s_intern = {}", a == s_intern);
    }

    @Invoking(createdTime = "2020-03-26 23:16", info = "intern02")
    public void intern02() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        LOGGER.info("str1.intern() == str1 = {}", str1.intern() == str1);

        String str2 = new StringBuilder("javaasda").toString();
        LOGGER.info("str2.intern() == str2 = {}", str2.intern() == str2);

        //2020-03-26 23:17:56.353  INFO 11336 ---
        // [           main] com.zrx.jvm.常量池
        // : str1.intern() == str1 = true

        // 因为 str1.intern()

        //2020-03-26 23:17:56.353  INFO 11336 ---
        // [           main] com.zrx.jvm.常量池
        // : str2.intern() == str2 = false
    }

    @Invoking(createdTime = "2020-03-26 23:40",info = "intern03")
    public void intern03() {
        String str1 = new String("123");
        LOGGER.info("str1.intern() == str1 = {}", str1.intern() == str1); //false

        String str2 = new String("123")+new String("123");
        LOGGER.info("str2.intern() == str2 = {}", str2.intern() == str2); //false
    }
}

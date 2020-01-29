package com.zrx.demo.propertiesTest;

import com.zrx.beam.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description
 * 配置文件信息注入测试
 * <p>
 * Data
 * 22:13
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootTest
public class BeanValueInjectTest {
    private final Person person;

    @Autowired
    public BeanValueInjectTest(Person person) {
        this.person = person;
    }

    @Test
    public void injectTest(){
        System.out.println("person = " + person);
    }
}

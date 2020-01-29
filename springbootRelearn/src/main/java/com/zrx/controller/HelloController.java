package com.zrx.controller;

import com.zrx.beam.Miao;
import com.zrx.beam.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Description
 * hello
 * <p>
 * Data
 * 21:11
 *
 * @author zrx
 * @version 1.0
 */


@RestController
public class HelloController {

    private final Person person;

    private final Miao miao;

    public HelloController(Person person, Miao miao) {
        this.person = person;
        this.miao = miao;
    }

    @Autowired


    @RequestMapping("/hello")
    public String hello() {
        return "hello, world!中文测试 \n" + person + "\n" + miao;
    }
}

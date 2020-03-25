package com.zrx.io.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * HelloController
 * <p>
 * Data
 * 2020/3/19-9:34
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RequestMapping("/hello")
public class HelloController {
    private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/repeat/{info}")
    public Object repeat(@PathVariable String info){
        LOGGER.info("/repeat/{info} = {}", info);
        return info;
    }

    @GetMapping("/communicate/{info}")
    public Object communicate(@PathVariable String info){
        LOGGER.info("/communicate/{info} = {}", info);
        return info;
    }
}

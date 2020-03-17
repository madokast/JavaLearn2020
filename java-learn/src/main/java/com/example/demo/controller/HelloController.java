package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Description
 * 学习 flux web
 * <p>
 * Data
 * 2020/3/17-21:52
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RequestMapping("/hello")
public class HelloController {
    private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    /**
     * 什么是 reactor
     * 即 JDK8 的 stream 和 JDK9 的 reactive stream
     * MONO 表示 0/1 个元素
     * Flux 表示 0-N 个元素
     * @param info just info
     * @return just info
     */
    @GetMapping("/just/{info}")
    public Mono<String> just(@PathVariable String info){
        return Mono.just(info);
    }
}

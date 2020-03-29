package com.zrx.ichiwanspringboot.controller;

import com.zrx.ichiwanspringboot.bean.DataWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description
 * 心跳连接
 * <p>
 * Data
 * 2020/3/26-11:21
 *
 * @author zrx
 * @version 1.0
 */

@CrossOrigin
@RestController
@RequestMapping("/heart/beat")
public class HeartBeatController {
    private final static Logger LOGGER = LoggerFactory.getLogger(HeartBeatController.class);

    private final ThreadLocal<DateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(()->new SimpleDateFormat("HH:mm:ss"));

    @GetMapping("/time")
    public DataWrapper<String> check() {
        DateFormat dateFormat = dateFormatThreadLocal.get();
        return DataWrapper.create("heart beat check", dateFormat.format(new Date()));
    }

}

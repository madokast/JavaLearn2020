package com.madokast.privacy.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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


@RestController
@RequestMapping(path = "/test/json")
public class JsonController {
    @GetMapping("/time")
    public Object getTime(){
        Map<String,Object> map = new HashMap<>();
        map.put("time",new Date());
        return map;
    }
}


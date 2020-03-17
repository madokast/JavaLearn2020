package com.madokast.privacy.learn.controller;

import com.madokast.privacy.learn.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * 异步任务
 * <p>
 * Data
 * 18:07
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class AsyncController {
    private final Logger LOGGER = LoggerFactory.getLogger(AsyncController.class);

    private final AsyncService asyncService;

    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/async")
    public Object async(){
        LOGGER.info("发布异步任务");
        asyncService.task();
        LOGGER.info("立即返回？");
        return "success";
    }

}

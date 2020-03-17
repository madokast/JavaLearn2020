package com.madokast.privacy.learn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Description
 * AsyncService
 * <p>
 * Data
 * 18:19
 *
 * @author zrx
 * @version 1.0
 */

@Service
public class AsyncService {
    private final Logger LOGGER = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public void task() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("任务执行结束");
    }
}

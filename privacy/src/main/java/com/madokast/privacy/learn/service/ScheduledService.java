package com.madokast.privacy.learn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Description
 * ScheduledService
 * <p>
 * Data
 * 18:24
 *
 * @author zrx
 * @version 1.0
 */

@Service
public class ScheduledService {
    private final Logger LOGGER = LoggerFactory.getLogger(ScheduledService.class);

    @Scheduled(cron = "0-59 * * * * *") //每秒执行
    public void scheduleTask(){
        if(started){
            LOGGER.info("定期执行任务");
        }
    }

    private boolean started = false;
}

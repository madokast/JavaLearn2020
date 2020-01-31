package com.zrx.listener;

import com.zrx.utils.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Description
 * ApplicationRunner
 * <p>
 * Data
 * 12:39
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class HelloApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Logger.getLogger().info("HelloApplicationRunner.run()...");
    }
}

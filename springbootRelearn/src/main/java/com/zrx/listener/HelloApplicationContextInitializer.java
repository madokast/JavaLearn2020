package com.zrx.listener;

import com.zrx.utils.Logger;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Description
 * ApplicationContextInitializer
 * 练习
 * <p>
 * Data
 * 12:32
 *
 * @author zrx
 * @version 1.0
 */

public class HelloApplicationContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        Logger.getLogger().info("HelloApplicationContextInitializer.initialize()..." +
                configurableApplicationContext);
    }
}

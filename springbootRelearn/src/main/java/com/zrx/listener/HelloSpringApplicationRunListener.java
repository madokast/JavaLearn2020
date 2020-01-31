package com.zrx.listener;

import com.zrx.utils.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Description
 * SpringApplicationRunListeners
 * <p>
 * Data
 * 12:35
 *
 * @author zrx
 * @version 1.0
 */

public class HelloSpringApplicationRunListener
        implements SpringApplicationRunListener {

    public HelloSpringApplicationRunListener(SpringApplication application, String[] args) {}



    @Override
    public void starting() {
        Logger.getLogger().info("HelloSpringApplicationRunListener.starting()...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        Logger.getLogger().info("HelloSpringApplicationRunListener.environmentPrepared()..."
        + environment.getSystemProperties().get("os.name"));
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        Logger.getLogger().info("HelloSpringApplicationRunListener.contextPrepared()...");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        Logger.getLogger().info("HelloSpringApplicationRunListener.contextPrepared()...");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        Logger.getLogger().info("HelloSpringApplicationRunListener.started()...");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        Logger.getLogger().info("HelloSpringApplicationRunListener.running()...");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        Logger.getLogger().info("HelloSpringApplicationRunListener.failed()...");
    }
}

package com.zrx.listener;

import com.zrx.utils.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Description
 * commandLineRunner
 * <p>
 * Data
 * 12:40
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Logger.getLogger().info("HelloCommandLineRunner.run()..." + Arrays.toString(args));
    }
}

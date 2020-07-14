package com.zrx.fragment.Others;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Description
 * 方法重写
 * <p>
 * Data
 * 2020/7/6-16:41
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-07-06 16:41")
public class 方法重写 {
    private final static Logger LOGGER = LoggerFactory.getLogger(方法重写.class);

    @Invoking(createdTime = "2020-07-06 16:42")
    public void test() {
        LOGGER.info("hello");

        Father f = new Son();
        f.fun();

        Son s = (Son) f;
        s.fun();
    }

    private static class Father {
        private void fun() {
            LOGGER.info("Father fun");
        }
    }
    private static class Son extends Father {
        private void fun() {
            LOGGER.info("Son fun");
        }
    }
}

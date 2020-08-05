package com.zrx;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

/**
 * Description
 * Hello
 * 使用 mybatis 自己的日志接口
 * <p>
 * Data
 * 2020/8/3-13:06
 *
 * @author zrx
 * @version 1.0
 */

public class HelloWorld {
    private static final Log LOGGER = LogFactory.getLog(HelloWorld.class);

    public static void main(String[] args) {
        LOGGER.debug("hello mybatis");
    }
}

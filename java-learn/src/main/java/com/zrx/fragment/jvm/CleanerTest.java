package com.zrx.fragment.jvm;

import com.zrx.Invoking;
import com.zrx.utils.MyLoggerFactory;
import com.zrx.utils.ThreadUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Description
 * 虚引用cleaner
 * <p>
 * Data
 * 2020/4/4-10:56
 *
 * @author zrx
 * @version 1.0
 */

//@Component
//@Invoking(createdTime = "2020-04-04 10:56",info = "虚引用cleaner")
public class CleanerTest {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(CleanerTest.class);

    @Invoking(createdTime = "2020-04-04 10:57",info = "虚引用cleaner回收测试")
    public void 虚引用cleaner回收测试(){
        /**
         * 2020-04-04 11:53:11.470  INFO 480 --- [           main] com.zrx.fragment.jvm.CleanerTest         : 创建强引用对象
         * 2020-04-04 11:53:11.470  INFO 480 --- [           main] com.zrx.fragment.jvm.CleanerTest         : obj = java.lang.Object@42ed89da
         * 2020-04-04 11:53:11.470  INFO 480 --- [           main] com.zrx.fragment.jvm.CleanerTest         : 加入到cleaner中
         * 2020-04-04 11:53:11.471  INFO 480 --- [           main] com.zrx.fragment.jvm.CleanerTest         : 丢弃强引用
         * 2020-04-04 11:53:11.471  INFO 480 --- [           main] com.zrx.fragment.jvm.CleanerTest         : 手动GC
         * 2020-04-04 11:53:11.504  INFO 480 --- [           main] com.zrx.fragment.jvm.CleanerTest         : 等待一段时间再停止运行
         * 2020-04-04 11:53:11.504  INFO 480 --- [ference Handler] com.zrx.fragment.jvm.CleanerTest         : 执行clean方法
         * 2020-04-04 11:53:12.507  INFO 480 --- [           main] com.zrx.fragment.jvm.CleanerTest         : 停止运行
         */

        LOGGER.info("创建强引用对象");
        Object obj = new Object();
        LOGGER.info("obj = {}", obj);

        LOGGER.info("加入到cleaner中");
        /**
         * 注意运行Java时虚拟机参数加上 --add-opens java.base/jdk.internal.ref=ALL-UNNAMED
         */
        //jdk.internal.ref.Cleaner.create(obj,()->LOGGER.info("执行clean方法"));

        LOGGER.info("丢弃强引用");
        obj = null;

        LOGGER.info("手动GC");
        System.gc();

        LOGGER.info("等待一段时间再停止运行");
        ThreadUtils.sleep(1000);

        LOGGER.info("停止运行");
    }
}

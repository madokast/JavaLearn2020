package com.zrx.fragment.jvm;

import com.zrx.Invoking;
import com.zrx.utils.MyLoggerFactory;
import com.zrx.utils.ThreadUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.ref.SoftReference;

/**
 * Description
 * 终结器引用
 * <p>
 * Data
 * 2020/4/4-12:09
 *
 * @author zrx
 * @version 1.0
 */

@Component
@Invoking(createdTime = "2020-04-04 12:09",info = "终结器引用")
@SuppressWarnings("all")
public class 终结器引用 {
    /**
     * 2020-04-04 12:12:27.400  INFO 4576 --- [           main] com.zrx.fragment.jvm.终结器引用               : 创建对象
     * 2020-04-04 12:12:27.400  INFO 4576 --- [           main] com.zrx.fragment.jvm.终结器引用               : 失去强引用
     * 2020-04-04 12:12:27.401  INFO 4576 --- [           main] com.zrx.fragment.jvm.终结器引用               : 手动GC
     * 2020-04-04 12:12:27.440  INFO 4576 --- [           main] com.zrx.fragment.jvm.终结器引用               : 等待1S
     * 2020-04-04 12:12:27.440  INFO 4576 --- [      Finalizer] com.zrx.fragment.jvm.终结器引用               : 调用finalize方法
     * 2020-04-04 12:12:28.443  INFO 4576 --- [           main] com.zrx.fragment.jvm.终结器引用               : 退出
     */

    private final static Logger LOGGER = MyLoggerFactory.getLogger(终结器引用.class);

    @Invoking(createdTime = "2020-04-04 12:09",info = "终结器引用")
    public void 终结器引用Test(){
        LOGGER.info("创建对象");
        Object obj = new Object(){
            @Override
            protected void finalize() throws Throwable {
                LOGGER.info("调用finalize方法");
                super.finalize();
            }
        };

        LOGGER.info("失去强引用");
        obj = null;

        LOGGER.info("手动GC");
        System.gc();

        LOGGER.info("等待1S");
        ThreadUtils.sleep(1000);

        LOGGER.info("退出");
    }
}

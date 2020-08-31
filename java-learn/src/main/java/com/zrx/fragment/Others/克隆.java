package com.zrx.fragment.Others;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * 克隆
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

@Invoking(createdTime = "2020-08-31 10:50")
public class 克隆 {
    private final static Logger LOGGER = LoggerFactory.getLogger(克隆.class);

    @Invoking(createdTime = "2020-08-31 10:52")
    public void test1() {
        A重写clone方法不实现接口1 a1 = new A重写clone方法不实现接口1();
        try {
            Object a1clone = a1.clone();
        } catch (CloneNotSupportedException e) {
            // e.printStackTrace();
            //java.lang.CloneNotSupportedException: com.zrx.fragment.Others.克隆$A重写clone方法不实现接口1
        }
    }

    @Invoking(createdTime = "2020-08-31 10:53")
    public void test2() {
        A重写clone方法不实现接口2 a2 = new A重写clone方法不实现接口2();
        try {
            Object a1clone = a2.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            //不会有异常
        }
    }


    /**
     * 调用 super.clone();
     * 抛出异常
     */
    class A重写clone方法不实现接口1 {
        int a;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    /**
     * 不调用 super.clone();
     * 没有异常
     */
    class A重写clone方法不实现接口2 {
        int a;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            A重写clone方法不实现接口2 obj = new A重写clone方法不实现接口2();
            obj.a = this.a;

            return obj;
        }
    }
}

package com.zrx.java8;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * Description
 * 方法引用
 * <p>
 * Data
 * 2020/3/27-23:16
 *
 * @author zrx
 * @version 1.0
 */

@Component
@Invoking(createdTime = "2020-03-27 23:16",info = "方法引用")
public class MethodRef {
    private final static Logger LOGGER = LoggerFactory.getLogger(MethodRef.class);

    public static void fun(String s1,String s2){
        LOGGER.info(s1+s2);
    }

    @Invoking(createdTime = "2020-03-27 23:16",info = "类::静态方法")
    public void 类中静态方法(){
        BiConsumer<String,String> b = MethodRef::fun;

        b.accept("对象1","对象2");
    }

    @Invoking(createdTime = "2020-03-27 23:20",info = "类::成员方法")
    public void 类中成员方法(){
        LOGGER.info("当lambda中(x,y)->x.fun(y)，就可以写成A:fun");

        BiFunction<Object,Object,Boolean> bf = Object::equals;
    }
}

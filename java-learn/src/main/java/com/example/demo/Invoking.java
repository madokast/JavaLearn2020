package com.example.demo;

import org.springframework.util.Assert;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * 注解此方法的类，会自动配置好并执行
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Invoking {
    /**
     * @return 简短信息
     */
    String info();

    /**
     * @return 详细信息
     */
    String[] details() default {};

    /**
     * @return 创建时间 格式 yyyy-MM-dd HH:mm
     */
    String createdTime();

    /**
     * @return 方法重复次数
     */
    int repeat() default 1;

    ThreadLocal<SimpleDateFormat> CREATE_TIME_FORMAT =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm"));

    class MethodWithCreatedTime {
        private Method method;
        private long createdTimeMs;

        private MethodWithCreatedTime() {
        }

        public static MethodWithCreatedTime create(Method method) {
            Assert.isTrue(method.isAnnotationPresent(Invoking.class), () ->
                    "方法" + method + "不含有@Invoking注解，请过滤后在创建MethodWithCreatedTime对象");

            Invoking invoking = method.getAnnotation(Invoking.class);
            long createdTimeMs;
            try {
                createdTimeMs = CREATE_TIME_FORMAT.get().parse(invoking.createdTime()).getTime();
            }catch (ParseException e){
                throw new RuntimeException(e);
            }

            MethodWithCreatedTime methodWithCreatedTime = new MethodWithCreatedTime();
            methodWithCreatedTime.setMethod(method);
            methodWithCreatedTime.setCreatedTimeMs(createdTimeMs);

            return methodWithCreatedTime;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public long getCreatedTimeMs() {
            return createdTimeMs;
        }

        public void setCreatedTimeMs(long createdTimeMs) {
            this.createdTimeMs = createdTimeMs;
        }

        @Override
        public String toString() {
            return "MethodWithCreatedTime{" +
                    "method=" + method +
                    ", createdTimeMs=" + createdTimeMs +
                    '}';
        }
    }
}

package com.zrx.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.*;
import java.util.function.Consumer;

/**
 * Description
 * MyLoggerFactory
 * 用于监听 bean 的 LOGGER
 * <p>
 * Data
 * 2020/3/18-17:59
 *
 * @author zrx
 * @version 1.0
 */

public class MyLoggerFactory {

    private final static Logger LOGGER = LoggerFactory.getLogger(MyLoggerFactory.class);

    private final static String PLACE_HOLDER = "{}";

    private final static int PLACE_HOLDER_LENGTH = PLACE_HOLDER.length();

    public static void addListenerOnBean(Object bean, Consumer<String> listener) {
        Class<?> beanClass = bean.getClass();
        Field loggerField;
        Logger logger;
        Field modifiers;

        try {
            // 拿到 LOGGER
            loggerField = beanClass.getDeclaredField("LOGGER");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("bean[{}]不存在LOGGER属性，无法安装监听器", bean);
            return;
        }

        if (!Logger.class.isAssignableFrom(loggerField.getType())) {
            LOGGER.error("bean[{}]中LOGGER属性不是{}类/子类，无法安装监听器", bean, Logger.class);
            return;
        }

        try {
            loggerField.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("bean[{}]的LOGGER属性无法代理，无法监听", bean);
            return;
        }

        try {
            Field[] declaredFields = Field.class.getDeclaredFields();
            LOGGER.info("declaredFields.length = {}", declaredFields.length);


//            modifiers = Field.class.getDeclaredField("modifiers");
            //java.lang.NoSuchFieldException: modifiers
//            modifiers.setAccessible(true);
//            modifiers.setInt(loggerField, loggerField.getModifiers() & ~Modifier.FINAL);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("bean[{}]的LOGGER属性无法代理，无法监听", bean);
            return;
        }

        try {
            logger = (Logger) loggerField.get(bean);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("bean[{}]的LOGGER属性无法代理，无法监听", bean);
            return;
        }

        try {
            loggerField.set(bean, box(logger, listener));
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("bean[{}]的LOGGER属性无法代理，无法监听", bean);
            return;
        }

        try {
            // 修改回来
//            modifiers.setInt(loggerField, loggerField.getModifiers() & ~Modifier.FINAL);
//            modifiers.setAccessible(false);
            loggerField.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("bean[{}]的LOGGER属性无法代理，无法监听", bean);
            return;
        }

        LOGGER.info("成功监听bean[{}]的LOGGER", bean);
    }

    private static Logger box(Logger log, Consumer<String> listener) {
        return (Logger) Proxy.newProxyInstance(
                log.getClass().getClassLoader(),
                log.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    String makeLog = makeLog(args);
                    if (makeLog != null)
                        listener.accept(makeLog);
                    return method.invoke(log, args);
                });
    }

    private static String makeLog(Object... args) {
        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
            String string = (String) args[0];
            if (args.length == 1)
                return string;
            else {
                StringBuilder stringBuilder = new StringBuilder(string);
                for (int i = 1; i < args.length; i++) {
                    String item = args[i].toString();
                    int indexOf = stringBuilder.indexOf(PLACE_HOLDER);
                    stringBuilder.delete(indexOf, indexOf + PLACE_HOLDER_LENGTH);
                    stringBuilder.insert(indexOf, item);
                }
                return stringBuilder.toString();
            }
        } else {
            return null;
        }
    }
}

package com.zrx.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

/**
 * Description
 * ToString
 * <p>
 * Data
 * 2020/3/23-21:25
 *
 * @author zrx
 * @version 1.0
 */

public class ToString {
    private final static Logger LOGGER = LoggerFactory.getLogger(ToString.class);

    private final static Map<Class<?>, Function<Object, String>> MAP = new HashMap<>();

    static {

    }

    public static String apply(Object a) {
        if (a == null)
            return "null";
        else if (a.getClass().isArray())
            return arrayToString(a);
        else
            return MAP.getOrDefault(a.getClass(), Object::toString).apply(a);
    }


    private static String arrayToString(Object array) {
        if (!array.getClass().isArray())
            throw new IllegalArgumentException(array + "is not an array");

        Class<?> componentType = array.getClass().componentType();

        if (componentType.isPrimitive()) {
            try {
                Method toString = Arrays.class.getMethod("toString", componentType.arrayType());
                return (String) toString.invoke(null, array);
            } catch (Exception ignore) {}
        }

        return Arrays.deepToString((Object[]) array);

    }

}

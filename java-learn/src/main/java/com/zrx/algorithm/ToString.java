package com.zrx.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public static String apply(Object a) {
        if (a == null)
            return "null";
        else if (a.getClass().isArray())
            return arrayToString(a);
        else if (a instanceof Map)
            return mapToString(a);
        else if (a instanceof Collection)
            return collectionToString(a);
        else
            return Objects.toString(a);
    }

    private static String collectionToString(Object a) {
        if (!(a instanceof Collection))
            throw new IllegalArgumentException(a + " is not a collection");

        Collection<?> collection = (Collection<?>) a;

        return collection.stream().map(ToString::apply).collect(Collectors.joining(", ", "{", "}"));
    }

    private static String mapToString(Object a) {
        if (!(a instanceof Map))
            throw new IllegalArgumentException(a + " is not a map");

        Map<?, ?> map = (Map<?, ?>) a;

        return map.entrySet().stream()
                .map(e -> "[" + apply(e.getKey()) + ", " + apply(e.getValue()) + "]")
                .collect(Collectors.joining(", ", "{", "}"));
    }

    private static String arrayToString(Object array) {
        if (!array.getClass().isArray())
            throw new IllegalArgumentException(array + "is not an array");

        Class<?> componentType = array.getClass().componentType();

        if (componentType.isPrimitive()) {
            try {
                Method toString = Arrays.class.getMethod("toString", componentType.arrayType());
                return (String) toString.invoke(null, array);
            } catch (Exception ignore) {
            }
        }

        return Arrays.deepToString((Object[]) array);

    }

    public static String arrayToFormatString(Object array) {
        if (!array.getClass().isArray())
            throw new IllegalArgumentException(array + "is not an array");

        Class<?> componentType = array.getClass().componentType();

        if (componentType.isArray()) {
            // 二维数组
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < Array.getLength(array); i++) {
                Object component = Array.get(array, i);
                sb.append(arrayToFormatString(component));
            }
            return sb.toString();

        } else {
            return "\n" + apply(array);
        }
    }

}

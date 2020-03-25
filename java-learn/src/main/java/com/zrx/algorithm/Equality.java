package com.zrx.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Description
 * 相等判断
 * <p>
 * Data
 * 2020/3/23-21:07
 *
 * @author zrx
 * @version 1.0
 */

public class Equality {
    private final static Logger LOGGER = LoggerFactory.getLogger(Equality.class);

    private static final Map<Class<?>, BiFunction<Object, Object, Boolean>> map = new HashMap<>();

    static {
        map.put(int[].class, (a, b) -> Arrays.equals((int[]) a, (int[]) b));
    }

    public static boolean isEqual(Object a, Object b) {
        return a.getClass().equals(b.getClass()) &&
                map.getOrDefault(a.getClass(), Object::equals).apply(a, b);
    }
}

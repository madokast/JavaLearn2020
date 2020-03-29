package com.zrx.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
        MAP.put(int[].class, arr -> Arrays.toString((int[]) arr));
    }

    public static String apply(Object a) {
        if (a == null)
            return "null";
        return MAP.getOrDefault(a.getClass(), Object::toString).apply(a);
    }
}

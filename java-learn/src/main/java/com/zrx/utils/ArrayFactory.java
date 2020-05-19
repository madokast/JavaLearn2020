package com.zrx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Objects;

/**
 * Description
 * IntArray
 * <p>
 * Data
 * 2020/3/23-17:56
 *
 * @author zrx
 * @version 1.0
 */

public class ArrayFactory {
    private final static Logger LOGGER = LoggerFactory.getLogger(ArrayFactory.class);

    public static int[] create(int... ints) {
        return ints;
    }

    public static int[][] create(int[]... intArrArr) {
        return intArrArr;
    }

    public static String[] create(String... strings) {
        return strings;
    }

    public static <T> T empty(Class<T> returnType) {
        if (!returnType.isArray()) {
            throw new IllegalArgumentException("returnType必须是数据类型，returnType=" + returnType);
        }
        return (T) Array.newInstance(returnType.getComponentType(), 0);
    }

    public static int[] create(List<Integer> list) {
        Objects.requireNonNull(list);
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}

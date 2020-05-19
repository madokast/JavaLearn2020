package com.zrx.algorithm;

import com.zrx.algorithm.leetcode.object.RepeatableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
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

    /**
     * 最智能的判断两个元素是否相同的方法
     *
     * @param a 元素 1
     * @param b 元素 2
     * @return 是否相同
     */
    public static boolean isEqual(Object a, Object b) {
        // null ?
        if (a == null || b == null)
            return a == b;

        // int[]
        if (a instanceof int[] && b instanceof int[])
            return Arrays.equals((int[]) a, (int[]) b);

        // 只要有一个是 RepeatableSet
        if (a instanceof RepeatableSet || b instanceof RepeatableSet)
            return Objects.equals(RepeatableSet.tryCreate(a), RepeatableSet.tryCreate(b));

        return Objects.deepEquals(a, b);
    }

}

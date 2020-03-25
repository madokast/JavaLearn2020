package com.zrx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class IntArray {
    private final static Logger LOGGER = LoggerFactory.getLogger(IntArray.class);

    public static int[] create(int...ints){
        Objects.requireNonNull(ints);
        return ints;
    }

    public static int[] create(List<Integer> list){
        Objects.requireNonNull(list);
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}

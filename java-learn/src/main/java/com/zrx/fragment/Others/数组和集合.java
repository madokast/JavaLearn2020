package com.zrx.fragment.Others;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * 数组和集合
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class 数组和集合 {
    private final static Logger LOGGER = LoggerFactory.getLogger(数组和集合.class);

    public void test() {
        Integer[] arr1 = {1, 2, 3};
        List<Integer> list = Arrays.asList(arr1);

        System.out.println("arr1 = " + Arrays.toString(arr1));
        list.set(1, 10);
        System.out.println("arr1 = " + Arrays.toString(arr1));
    }
}

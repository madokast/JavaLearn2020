package com.zrx.algorithm.专题.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * 插入排序法
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class InsertionSort implements Sort {
    private final static Logger LOGGER = LoggerFactory.getLogger(InsertionSort.class);

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) swap(arr, j, j - 1);
            }
        }
    }
}

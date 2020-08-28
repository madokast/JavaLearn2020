package com.zrx.algorithm.专题.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * 选择排序法
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class SelectionSort implements Sort {
    private final static Logger LOGGER = LoggerFactory.getLogger(SelectionSort.class);

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = minIndex(arr, i, arr.length);
            swap(arr, minIndex, i);
        }
    }

    /**
     * @return 数组 arr 在 [from, to) 范围内最小元素的位置
     */
    private int minIndex(int[] arr, int form, int to) {
        int ret = form;
        for (int i = form + 1; i < to; i++) {
            if (arr[ret] > arr[i]) ret = i;
        }

        return ret;
    }
}

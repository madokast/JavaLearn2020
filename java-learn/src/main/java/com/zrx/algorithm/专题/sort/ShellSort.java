package com.zrx.algorithm.专题.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * 希尔排序法
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class ShellSort implements Sort {
    private final static Logger LOGGER = LoggerFactory.getLogger(ShellSort.class);

    @Override
    public void sort(int[] arr) {
        int h = 1; // 步长
        while (h < arr.length / 3) h = 3 * h + 1; // 计算初始步长
        while (h >= 1) {
            for (int i = 0; i < h; i++) {
                // i i+h i+2h ...
                sort(arr, i, h);
            }
            h /= 3;
        }
    }

    /**
     * 将数组 arr 中 start start+h start+2h ... 排序
     * 使用插入排序法
     */
    private void sort(int[] arr, int start, int h) {
        for (int i = start; i < arr.length; i += h) {
            for (int j = i; j >= h; j -= h) {
                if (arr[j] < arr[j - h]) swap(arr, j, j - h);
            }
        }
    }
}

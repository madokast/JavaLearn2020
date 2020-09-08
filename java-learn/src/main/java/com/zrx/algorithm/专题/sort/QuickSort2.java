package com.zrx.algorithm.专题.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * Description
 * QuickSort
 * 另一种方法
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class QuickSort2 implements Sort {
    private final static Logger LOGGER = LoggerFactory.getLogger(QuickSort2.class);

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private void sort(int[] arr, int startIn, int endEx) {
        if (startIn >= endEx) return;

        int pivotIndex = findPivotIndex(arr, startIn, endEx);
        int pivot = arr[pivotIndex];

        swap(arr, pivotIndex, startIn);

        int i = startIn;
        int j = endEx - 1;

        while (i < j) {
            while (j > i && arr[j] >= pivot) j--;
            while (i < j && arr[i] <= pivot) i++;
            if (i < j) swap(arr, i, j);
        }

        swap(arr, startIn, i);

        sort(arr, startIn, i);
        sort(arr, i + 1, endEx);
    }

    private int findPivotIndex(int[] arr, int startIn, int endEx) {
        return (startIn + endEx) / 2;
    }
}

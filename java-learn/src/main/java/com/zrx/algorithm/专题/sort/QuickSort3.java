package com.zrx.algorithm.专题.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * Description
 * QuickSort3
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class QuickSort3 implements Sort {
    private final static Logger LOGGER = LoggerFactory.getLogger(QuickSort3.class);

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private void sort(int[] arr, int startIn, int endEx) {
        if (startIn >= endEx) return;

        int pivotIndex = findPivotIndex(arr, startIn, endEx);

        int pivot = arr[pivotIndex];

        // swap pivot to first element
        swap(arr, pivotIndex, startIn);

        int i = startIn;

        for (int j = i + 1; j < endEx; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, startIn, i);

        sort(arr, startIn, i);
        sort(arr, i + 1, endEx);
    }

    private int findPivotIndex(int[] arr, int startIn, int endEx) {
        return (startIn + endEx) / 2;
    }
}
